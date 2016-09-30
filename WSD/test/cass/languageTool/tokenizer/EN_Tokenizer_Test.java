package cass.languageTool.tokenizer;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cass.languageTool.tokenizer.EN_Tokenizer;

public class EN_Tokenizer_Test {
	@Test
	public void test(){
		
		EN_Tokenizer tok = new EN_Tokenizer();
		List<String> test = new ArrayList<String>();
		List<String> result = new ArrayList<String>();
		test.add("The");
		test.add("cow");
		test.add("jumped");
		test.add("over");
		test.add("the");
		test.add("moon");
		result = tok.tokenize("The cow jumped over the moon");
		
		for(int i=0; i<test.size();i++){
			assertEquals(test.get(i), result.get(i));
		}
		
		test.clear();
		result.clear();
		test.add("asjdgasfhjbas");		
		result = tok.tokenize("asjdgasfhjbas");
		for(int i=0; i<test.size();i++){
			assertEquals(test.get(i), result.get(i));
		}
		
		test.clear();
		result.clear();
		test.add("hello");	
		test.add(",");
		test.add("how");
		test.add(".");
		test.add("are");
		test.add("you");
		test.add("?");
		result = tok.tokenize("hello, how.  are you?");
		
		for(int i=0; i<test.size();i++){
			assertEquals(test.get(i), result.get(i));
		}
		
		 test.clear();
		 result.clear();
		 test.add("today");
		 test.add("is");
		 test.add("a");
		 test.add("beautiful");
		 test.add("day");
		 result = tok.tokenize("today is a beautiful day"); 
		 for(int i=0; i<test.size();i++){
				assertEquals(test.get(i), result.get(i));
		}
		 test.clear();
		 result.clear();
		 test.add("0x4356abdc");
		 test.add("07777");
		 test.add("[");
		 test.add("]");
		 result = tok.tokenize("0x4356abdc 07777 [] ");
		 for(int i=0; i<test.size();i++){
				assertEquals(test.get(i), result.get(i));
		}
		 test.clear();
		 result.clear();
		 test.add("array");
		 test.add("[");
		 test.add("xyz");
		 test.add("]");
		 test.add("+");
		 test.add("=");
		 test.add("pi");
		 test.add("3.14159e-10");
		 result = tok.tokenize("array[xyz ] + = pi 3.14159e-10 ");
		 for(int i=0; i<test.size();i++){
				assertEquals(test.get(i), result.get(i));
		} 
		
		test.clear();
		result.clear();
 		test.add("+");
 		test.add("123.0");
 		test.add("0xg");
 		test.add("0Xf21B");
 		test.add("07721");
		test.add("[");
 		test.add("hi");
 		result = tok.tokenize("+123.0 0xg0Xf21B 07721 [hi");
 		 for(int i=0; i<test.size();i++){
				assertEquals(test.get(i), result.get(i));
		} 
		
		test.clear();
		result.clear();
  		test.add("[0x5C6E]");
  		test.add("123");
  		test.add("[0x5C16]");
  		test.add("<");
  		test.add(">");
  		test.add("123.2");
  		test.add(".");
  		test.add("eeeeeee");
 		test.add("01234567");
 		test.add("89");
 		result = tok.tokenize(" \n123\b <> 123.2.eeeeeee 0123456789 ");
 		 for(int i=0; i<test.size();i++){
				assertEquals(test.get(i), result.get(i));
		}
		
		test.clear();
		result.clear();
 		test.add("238.22e92.2");
 		test.add("[0x5c74]");
 		test.add("[0x5c]");
 		test.add("0x9F2");
 		test.add(".");
 		test.add("0");
 		test.add("abc");
 		test.add("+");
 		test.add("-");
 		test.add("~");
 		test.add("|");
 		test.add("{");
 		test.add("HI");
 		test.add("}");
 		result = tok.tokenize("238.22e92.2 \t\\ 0x9F2.0abc +-~ | {HI}");
 		for(int i=0; i<test.size();i++){
				assertEquals(test.get(i), result.get(i));
		} 
		
		test.clear();
		result.clear();
 		test.add("0xZ");
 		test.add("22");
 		test.add("POW");
 		test.add(".");
 		test.add("2");
 		test.add(";");
 		test.add(":");
 		test.add("1337.k");
 		result = tok.tokenize("0xZ22 POW.2 ;:1337.k");
 		for(int i=0; i<test.size();i++){
				assertEquals(test.get(i), result.get(i));
		} 
	}
}
