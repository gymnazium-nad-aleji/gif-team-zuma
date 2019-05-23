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

import org.junit.Test;
import static org.junit.Assert.*;

public class LzwByteStreamSplitterTest {
    @Test
    public void smoke() {
        ArrayByteOutputStream result = new ArrayByteOutputStream();
        LzwByteStreamSplitter splitter = new LzwByteStreamSplitter(result, 3);

        splitter.write(100);
        splitter.write(101);
        splitter.write(102);
        splitter.write(103);
        splitter.write(104);
        splitter.write(105);
        splitter.write(106);
        splitter.write(107);
        splitter.write(108);
        splitter.write(109);
        splitter.write(110);
        splitter.done();

        byte[] packed = result.toByteArray();
        assertArrayEquals(new byte[] {
                3, 100, 101, 102,
                3, 103, 104, 105,
                3, 106, 107, 108,
                2, 109, 110, 0
            }, packed);
    }
}
