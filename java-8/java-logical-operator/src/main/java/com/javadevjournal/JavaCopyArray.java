package com.javadevjournal;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class JavaCopyArray {

    public class ArrayCopyExample {
        public static void main(String[] args) {
            int[] sourceArray = {1, 2, 3, 4, 5};
            int[] targetArray = new int[sourceArray.length];

            for (int i = 0; i < sourceArray.length; i++) {
                targetArray[i] = sourceArray[i];
            }
        }
    }

    public class ArrayCopyExample {
        public static void main(String[] args) {
            int[] sourceArray = {1, 2, 3, 4, 5};
            int[] targetArray = new int[sourceArray.length];

            System.arraycopy(sourceArray, 0, targetArray, 0, sourceArray.length);
        }
    }

    public class ArrayCopyExample {
        public static void main(String[] args) {
            int[] sourceArray = {1, 2, 3, 4, 5};
            int[] targetArray = Arrays.copyOf(sourceArray, sourceArray.length);
        }
    }

    public class ArrayCopyExample {
        public static void main(String[] args) {
            int[] sourceArray = {1, 2, 3, 4, 5};
            int[] targetArray = sourceArray.clone();
        }
    }

    public class ArrayCopyExample {
        public static void main(String[] args) {
            int[] sourceArray = {1, 2, 3, 4, 5};
            int[] targetArray = Arrays.stream(sourceArray).toArray();
        }
    }

}
