// License
// Copyright 2007 Hamaad Musharaf Shah
// Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
// http://www.apache.org/licenses/LICENSE-2.0
// Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

import java.io.*;
import java.lang.*;
import java.util.*;

@SuppressWarnings("unchecked")
public class KS2 extends Methods {

    public int[] A;

    public int[] B;

    public KS2(int[] I_1, int[] I_2) {
        this.A = I_1;
        this.B = I_2;
    }

    public KS2(long[] L_1, long[] L_2) {
        List<Long> Comb_data = new ArrayList<Long>();

        for (int i = 0; i < L_1.length; i++) {
            Comb_data.add(L_1[i]);
        }

        for (int i = 0; i < L_2.length; i++) {
            Comb_data.add(L_2[i]);
        }

        Long[] Temp = Comb_data.toArray(new Long[0]);
        long[] Comb_data_1 = new long[Temp.length];

        for (int i = 0; i < Comb_data_1.length; i++) {
            Comb_data_1[i] = Temp[i];
        }

        long[] L_keys = Keys_table_long(Comb_data_1);
        int[] I_keys = new int[L_keys.length];

        int n = 0;

        for (int i = 0; i < I_keys.length; i++) {
            I_keys[i] = n;
            n++;
        }

        int[] Comb_data_2 = new int[Comb_data_1.length];

        for (int i = 0; i < Comb_data_2.length; i++) {
            for (int j = 0; j < I_keys.length; j++) {
                if (Comb_data_1[i] == L_keys[j]) Comb_data_2[i] = I_keys[j];
            }
        }

        int[] I_1 = new int[L_1.length];

        for (int i = 0; i < I_1.length; i++) {
            I_1[i] = Comb_data_2[i];
        }

        int[] I_2 = new int[L_2.length];

        int j = 0;

        for (int i = I_1.length; i < Comb_data_2.length; i++) {
            I_2[j] = Comb_data_2[i];
            j++;
        }

        this.A = I_1;
        this.B = I_2;
    }

    public KS2(float[] F_1, float[] F_2) {
        List<Float> Comb_data = new ArrayList<Float>();

        for (int i = 0; i < F_1.length; i++) {
            Comb_data.add(F_1[i]);
        }

        for (int i = 0; i < F_2.length; i++) {
            Comb_data.add(F_2[i]);
        }

        Float[] Temp = Comb_data.toArray(new Float[0]);
        float[] Comb_data_1 = new float[Temp.length];

        for (int i = 0; i < Comb_data_1.length; i++) {
            Comb_data_1[i] = Temp[i];
        }

        float[] F_keys = Keys_table_float(Comb_data_1);
        int[] I_keys = new int[F_keys.length];

        int n = 0;

        for (int i = 0; i < I_keys.length; i++) {
            I_keys[i] = n;
            n++;
        }

        int[] Comb_data_2 = new int[Comb_data_1.length];

        for (int i = 0; i < Comb_data_2.length; i++) {
            for (int j = 0; j < I_keys.length; j++) {
                if (Comb_data_1[i] == F_keys[j]) Comb_data_2[i] = I_keys[j];
            }
        }

        int[] I_1 = new int[F_1.length];

        for (int i = 0; i < I_1.length; i++) {
            I_1[i] = Comb_data_2[i];
        }

        int[] I_2 = new int[F_2.length];

        int j = 0;

        for (int i = I_1.length; i < Comb_data_2.length; i++) {
            I_2[j] = Comb_data_2[i];
            j++;
        }

        this.A = I_1;
        this.B = I_2;
    }

    public KS2(String[] S_1, String[] S_2) {
        List<String> Comb_data = new ArrayList<String>();

        for (int i = 0; i < S_1.length; i++) {
            Comb_data.add(S_1[i]);
        }

        for (int i = 0; i < S_2.length; i++) {
            Comb_data.add(S_2[i]);
        }

        String[] Comb_data_1 = Comb_data.toArray(new String[0]);

        String[] S_keys = Keys_table_string(Comb_data_1);
        int[] I_keys = new int[S_keys.length];

        int n = 0;

        for (int i = 0; i < I_keys.length; i++) {
            I_keys[i] = n;
            n++;
        }

        int[] Comb_data_2 = new int[Comb_data_1.length];

        for (int i = 0; i < Comb_data_2.length; i++) {
            for (int j = 0; j < I_keys.length; j++) {
                if (Comb_data_1[i] == S_keys[j]) Comb_data_2[i] = I_keys[j];
            }
        }

        int[] I_1 = new int[S_1.length];

        for (int i = 0; i < I_1.length; i++) {
            I_1[i] = Comb_data_2[i];
        }

        int[] I_2 = new int[S_2.length];

        int j = 0;

        for (int i = I_1.length; i < Comb_data_2.length; i++) {
            I_2[j] = Comb_data_2[i];
            j++;
        }

        this.A = I_1;
        this.B = I_2;
    }

    public double KS2() {
        List<Integer> Comb_data = new ArrayList<Integer>();

        for (int i = 0; i < A.length; i++) {
            Comb_data.add(A[i]);
        }

        for (int i = 0; i < B.length; i++) {
            Comb_data.add(B[i]);
        }

        Integer[] Temp_1 = Comb_data.toArray(new Integer[0]);
        int[] Comb_data_1 = new int[Temp_1.length];

        for (int i = 0; i < Comb_data_1.length; i++) {
            Comb_data_1[i] = Temp_1[i];
        }

        // The following version of doing the KS2 test
        // is based on Durbin's treatment in
        // Durbin, 1973, p.39-40.
        float[][] x = new float[A.length + B.length][2];

        for (int i = 0; i < x.length; i++) {
            x[i][0] = (float) Comb_data_1[i];
        }

        for (int j = 0; j < A.length; j++) {
            x[j][1] = 0.0F;
        }

        for (int j = A.length; j < x.length; j++) {
            x[j][1] = 1.0F;
        }

        /* http://forum.java.sun.com/thread.jspa
         * ?threadID=716459&messageID=4150630
         */
        // Accessed on 26 July 2007.
        Arrays.sort(x, new Comparator() {
                    public int compare(Object o1, Object o2) {
                        float[] a1 = (float[]) o1;
                        float[] a2 = (float[]) o2;
                        return Float.compare(a1[0], a2[0]);
                    }
                }
        );

        int[] count = new int[x.length];

        int k = 1;

        for (int i = 0; i < x.length; i++) {
            if (x[i][1] == 0.0) count[i] += k;
            else count[i] = k - 1;

            if (x[i][1] == 0.0) k++;
            else k = k;
        }

        double[] F = new double[count.length];

        for (int i = 0; i < F.length; i++) {
            F[i] = count[i] / (double) A.length;
        }

        double[] Temp_2 = new double[A.length + B.length];
        double[] Temp_3 = new double[A.length + B.length];

        for (int i = 0; i < Temp_2.length; i++) {
            Temp_2[i] = F[i] - ((double) (i + 1) / (double) (A.length + B.length));

            Temp_3[i] = ((double) (i + 1) / (double) (A.length + B.length)) - F[i];
        }

        double D_1 = (double) ((double) (A.length + B.length) / (double) (B.length)) * Max(Temp_2);
        double D_2 = (double) ((double) (A.length + B.length) / (double) (B.length)) * Max(Temp_3);
        double K = Math.max(D_1, D_2);

        return K;
    }

    public static void main(String[] args) {
    }

}


