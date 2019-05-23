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

import java.util.Arrays;
import java.util.Iterator;

/** LZW compressor. */
public class LzwCompressor {

    public static void compress(Iterable<Integer> indices, int firstUnusedIndex, LzwOutputStream output) {
        final int CLEAR_CODE = firstUnusedIndex;
        final int EOI_CODE = firstUnusedIndex + 1;

        LzwCodeTable codeTable = new LzwCodeTable();
        for (int i = 0; i < firstUnusedIndex; i++) {
            codeTable.add(i);
        }
        codeTable.add(CLEAR_CODE);
        codeTable.add(EOI_CODE);

        output.add(CLEAR_CODE, codeTable.getBits());

        Iterator<Integer> it = indices.iterator();
        if (!it.hasNext()) {
            output.add(EOI_CODE, codeTable.getBits());
            return;
        }

        while (it.hasNext()) {
            int next = it.next();
        }

        output.add(EOI_CODE, codeTable.getBits());

        output.done();
    }
}
