/*
 * MIT License
 * Copyright (c) 2018 Gymnazium Nad Aleji
 * Copyright (c) 2018 Vojtech Horky
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package cz.alisma.alej.prog.image.gif;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LzwCodeTableTest {
    @Test
    public void searchWorks() {
        LzwCodeTable table = new LzwCodeTable();
        table.add(0);
        table.add(1, 2);
        table.add(3, 4, 5);
        table.add(6, 7, 8, 9);

        assertTrue(table.contains(1, 2));
        assertEquals(1, table.indexOf(1, 2));

        assertTrue(table.contains(6, 7, 8, 9));
        assertEquals(3, table.indexOf(6, 7, 8, 9));

        assertFalse(table.contains(1));
        assertEquals(-1, table.indexOf(1));

        assertFalse(table.contains(3, 4, 5, 6));
        assertEquals(-1, table.indexOf(3, 4, 5, 6));
    }

    @Test
    public void bitSizingWorks() {
        LzwCodeTable table = new LzwCodeTable();

        table.add(0);
        assertEquals(1, table.getBits());
        table.add(1);
        assertEquals(1, table.getBits());

        table.add(2);
        table.add(3);
        assertEquals(2, table.getBits());

        table.add(4);
        table.add(5);
        table.add(6);
        table.add(7);
        assertEquals(3, table.getBits());
        table.add(8);
        assertEquals(4, table.getBits());
    }
}
