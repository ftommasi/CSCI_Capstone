/*
 *   OpenOffice.org extension for syntax highlighting
 *   Copyright (C) 2008  Cédric Bosdonnat cedricbosdo@openoffice.org
 *
 *   This library is free software; you can redistribute it and/or
 *   modify it under the terms of the GNU Library General Public
 *   License as published by the Free Software Foundation; 
 *   version 2 of the License.
 *
 *   This library is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *   Library General Public License for more details.
 *
 *   You should have received a copy of the GNU Library General Public
 *   License along with this library; if not, write to the Free
 *   Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.libreoffice.example.comp.tests;

import org.libreoffice.example.comp.CASSImpl;
import org.libreoffice.example.comp.tests.base.UnoTestCase;



/**
 * This is a sample Unit test case for Uno extensions, feel free to create more of them.
 */
public class ProjectTest extends UnoTestCase {

    public void testSynonyms() {
    	//TODO(TEAM): write tests for synonym Manager classes
    	CASSImpl s= new CASSImpl(null);
		String[] mine = s.getSynonym("test");
		for(int i=0; i<mine.length; i++){
				String output = mine[i];
				System.out.println(output);
		}
    }
}
