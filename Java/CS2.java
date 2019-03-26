// License
// Copyright 2007 Hamaad Musharaf Shah
// Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
// http://www.apache.org/licenses/LICENSE-2.0
// Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

import java.io.*;
import java.lang.*;
import java.util.*;

public class CS2 extends Methods {

    public float alpha;

    public int[] A;

    public int[] B;

    public CS2(int[] I_1, int[] I_2) {
        this.A = I_1;
        this.B = I_2;
    }

    public CS2(long[] L_1, long[] L_2) {
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

    public CS2(float[] F_1, float[] F_2) {
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

    public CS2(String[] S_1, String[] S_2) {
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

    // http://fonsg3.let.uva.nl/Service/Statistics/EqualDistribX2.html
// Accessed on 7 Aug 2007.
    public double CS2() {
        int[] Frq_A = null;
        int[] Frq_B = null;

        int[] x = Uncommon(A, B);
        int[] y = Uncommon(B, A);

        if (x.length != 0 || y.length != 0) {
            List<Integer> Comb_data = new ArrayList<Integer>();

            for (int i = 0; i < A.length; i++) {
                Comb_data.add((int) A[i]);
            }

            for (int i = 0; i < B.length; i++) {
                Comb_data.add((int) B[i]);
            }

            Integer[] Temp = Comb_data.toArray(new Integer[0]);
            int[] C_data = new int[Temp.length];

            for (int i = 0; i < C_data.length; i++) {
                C_data[i] = Temp[i];
            }

            int[] Comb_keys = Keys_table_int(C_data);

            Frq_A = new int[Comb_keys.length];
            Frq_B = new int[Comb_keys.length];

            for (int i = 0; i < Comb_keys.length; i++) {
                Frq_A[i] = Freq_element_int(A, Comb_keys[i]);
                Frq_B[i] = Freq_element_int(B, Comb_keys[i]);
            }
        } else {
            Frq_A = Frequency_vector_int(A);
            Frq_B = Frequency_vector_int(B);
        }

        int[][][] Joint = new int[2][Frq_A.length][2];

        for (int i = 0; i < Frq_A.length; i++) {
            Joint[0][i][0] = Frq_A[i];
            Joint[1][i][1] = Frq_B[i];
        }

        int[][] A_MPD = R_C_totals(Joint, "Rows");
        int[][] B_MPD = R_C_totals(Joint, "Columns");

        float[][][] Prod_marg = new float[2][Frq_A.length][2];

        for (int i = 0; i < Prod_marg.length; i++) {
            for (int j = 0; j < Prod_marg[i].length; j++) {
                Prod_marg[i][j][0] = (float) ((A_MPD[i][0] * B_MPD[j][0]) / (float) (A.length + B.length));
                Prod_marg[i][j][1] = (float) ((A_MPD[i][0] * B_MPD[j][0]) / (float) (A.length + B.length));
            }
        }

        double Ans = 0.0D;

        for (int i = 0; i < Joint.length; i++) {
            for (int j = 0; j < Frq_A.length; j++) {
                Ans += (double) (Math.pow(Joint[i][j][i] - Prod_marg[i][j][i], 2) / (double) (Prod_marg[i][j][i]));
            }
        }

        double DoF = (double) ((2.0D - 1.0D) * (Frq_A.length - 1));

        double z = (double) ((Math.pow((Ans / DoF), 1.0D / 3.0D) - (1.0D - (2.0D / (9.0D * DoF)))) / (double) (Math.sqrt(2.0D / (9.0D * DoF))));

        if (DoF > 30.0D) return z;
        else return Ans;
    }

    public static void main(String[] args) {
    }

}
