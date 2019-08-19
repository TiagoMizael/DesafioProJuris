package br.com.projuris;

import br.com.projuris.interfaces.FindArray;

public class MyFindArray implements FindArray {
    @Override
    public int findArray(int[] array, int[] subArray) {

        int pos = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < subArray.length; j++) {
                if (array[i] != subArray[j]) {
                    break;
                } else if (array[i] == subArray[j]) {
                    boolean match = validaMatch(array, subArray, i, j);
                    if (match) {
                        pos = i;
                    } else {
                        pos = -1;
                    }
                }
            }
        }
        return pos;
    }

    public static boolean validaMatch(int[] array, int[] subArray, int index, int j) {
        boolean valida = false;
        int size = array.length;
        for (int matchedPos = j; matchedPos < subArray.length; matchedPos++, index++) {
            if (index < size) {
                if (array[index] == subArray[matchedPos]) {
                    valida = true;
                    continue;
                } else {
                    valida = false;
                }
            }else {
                valida = false;
            }
        }
        return valida;
    }
}
