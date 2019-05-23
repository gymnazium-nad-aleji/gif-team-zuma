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
package cz.alisma.alej.prog.image;

/** Various utilities. */
public class Utils {
    public static int getNearestGreaterOrEqualPowerOfTwo(int value) {
        if (value <= 0) {
            return 0;
        }
        if (value == 1) {
            return 1;
        }
        int bound = 2;
        while (value > bound) {
            bound *= 2;
        }
        return bound;
    }

    public static int getHighestSetBit(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Highest set bit works only for positive values.");
        }
        int bit = -1;
        while (value > 0) {
            bit++;
            value /= 2;
        }
        return bit;
    }

    public static String asBinary(int i, int width) {
        String fmt = String.format("%%%ds", width);
        return String.format(fmt, Integer.toBinaryString(i)).replace(' ', '0');
    }
}
