// License
// Copyright 2007 Hamaad Musharaf Shah
// Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
// http://www.apache.org/licenses/LICENSE-2.0
// Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

import java.io.*;
import java.lang.*;
import java.util.*;

public class Closeness extends Methods {

    public float d;

    public float e;

    public int[] A;

    public int[] B;

    public Closeness(int[] I_1, int[] I_2, float d, float e) {
        this.d = d;
        this.e = e;
        this.A = I_1;
        this.B = I_2;
    }

    public Closeness(float[] F_1, float[] F_2, float d, float e) {
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

        this.d = d;
        this.e = e;
        this.A = I_1;
        this.B = I_2;
    }

    public Closeness(String[] S_1, String[] S_2, float d, float e) {
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

        this.d = d;
        this.e = e;
        this.A = I_1;
        this.B = I_2;
    }

    public static String L2_Test(int[] A, int[] B, int[] S_P, int[] S_Q, int m, float e, float d, String Type) {
        String[] Ans = new String[Math.abs((int) Math.log(1.0 / d))];

        int[] Count = {0, 0};

        for (int j = 0; j < Ans.length; j++) {
            if (Type == "Normal") {
                int[] F_p = Sample(A, m);
                int[] F_q = Sample(B, m);
                int[] Q_p = Sample(A, m);
                int[] Q_q = Sample(B, m);

                Output_file_int(F_p, "Closeness_P.txt");
                Output_file_int(F_q, "Closeness_Q.txt");

                int Self_Col_P = Self_col_prob(F_p);
                int Self_Col_Q = Self_col_prob(F_q);

                int Col_PQ = Col_prob(Q_p, Q_q);

                float r = ((2.0F * (float) m) / ((float) (m - 1.0F))) * (float) (Self_Col_P + Self_Col_Q);

                float s = (float) (2.0F * Col_PQ);

                String[] Result = {"Fail!", "Pass!"};

                if ((r - s) > (float) ((Math.pow(m, 2) * Math.pow(e, 2)) / 2.0F)) Ans[j] = Result[0];
                else Ans[j] = Result[1];

                if (Ans[j] == Result[0]) Count[0] += 1;
                else Count[1] += 1;
            } else {
                int[] F_p = Sample_light(A, S_P, m);
                int[] F_q = Sample_light(B, S_Q, m);
                int[] Q_p = Sample_light(A, S_P, m);
                int[] Q_q = Sample_light(B, S_Q, m);

                Output_file_int(F_p, "Closeness_P.txt");
                Output_file_int(F_q, "Closeness_Q.txt");

                int Self_Col_P = Self_col_prob(F_p);
                int Self_Col_Q = Self_col_prob(F_q);

                int Col_PQ = Col_prob(Q_p, Q_q);

                float r = ((2.0F * (float) m) / ((float) (m - 1.0F))) * (float) (Self_Col_P + Self_Col_Q);

                float s = (float) (2.0F * Col_PQ);

                String[] Result = {"Fail!", "Pass!"};

                if ((r - s) > (float) ((Math.pow(m, 2) * Math.pow(e, 2)) / 2.0F)) Ans[j] = Result[0];
                else Ans[j] = Result[1];

                if (Ans[j] == Result[0]) Count[0] += 1;
                else Count[1] += 1;
            }
        }

        if (Count[0] > Count[1]) return "Fail!";
        else return "Pass!";
    }

    public String Closeness() {
        Random generator = new Random();

        int n = Keys_table_int(A).length;

        int m = (int) ((Math.pow(n, 2.0 / 3.0)) / (Math.pow(e, 4)));

        int M = (int) ((Math.max(Math.pow(e, -2), 4)) * (Math.pow(n, 2.0 / 3.0)) * (Math.log(n)));

        int[] Sample_P = Sample(A, M);
        int[] Sample_Q = Sample(B, M);

        List<Integer> S_P_temp = new ArrayList<Integer>();
        List<Integer> S_Q_temp = new ArrayList<Integer>();

        for (int i = 0; i < Sample_P.length; i++) {
            if ((float) Freq_index_int(Sample_P, i) >= (float) ((1 - (e / 63.0F)) * M * Math.pow(n, -2.0 / 3.0)))
                S_P_temp.add(Sample_P[i]);
        }

        for (int i = 0; i < Sample_Q.length; i++) {
            if ((float) Freq_index_int(Sample_Q, i) >= (float) ((1 - (e / 63.0F)) * M * Math.pow(n, -2.0 / 3.0)))
                S_Q_temp.add(Sample_Q[i]);
        }

        Integer[] X = S_P_temp.toArray(new Integer[0]);
        Integer[] Y = S_Q_temp.toArray(new Integer[0]);

        int[] S_P = new int[X.length];
        int[] S_Q = new int[Y.length];

        for (int i = 0; i < S_P.length; i++) {
            S_P[i] = X[i];
        }

        for (int i = 0; i < S_Q.length; i++) {
            S_Q[i] = Y[i];
        }

        if (S_P_temp.isEmpty() == true && S_Q_temp.isEmpty() == true)
            return L2_Test(A, B, S_P, S_Q, m, (float) (e / (2.0F * Math.sqrt(n))), (float) (d / 2.0F), "Normal");
        else {
            List<Integer> Common = new ArrayList<Integer>();

            for (int i = 0; i < S_P.length; i++) {
                for (int j = 0; j < S_Q.length; j++) {
                    if (S_P[i] == S_Q[i]) Common.add(S_P[i]);
                }
            }

            Integer[] Temp = Common.toArray(new Integer[0]);

            int[] Common_elements = new int[Temp.length];

            for (int i = 0; i < Temp.length; i++) {
                Common_elements[i] = Temp[i];
            }

            List<Integer> L = new ArrayList<Integer>();

            for (int i = 0; i < Common_elements.length; i++) {
                L.add((int) ((Freq_element_int(S_P, Common_elements[i]) - Freq_element_int(S_Q, Common_elements[i]))));
            }

            Integer[] Temp_y = L.toArray(new Integer[0]);

            int L_count = 0;

            for (int i = 0; i < Temp_y.length; i++) {
                L_count += Temp_y[i];
            }

            if (((float) L_count) > (float) ((e * M) / 8.0F)) return "Fail!!!";
            else {
                return L2_Test(A, B, S_P, S_Q, m, (float) (e / (2.0F * Math.sqrt(n))), (float) (d / 2.0F), "Light");
            }
        }
    }

    public static void main(String[] args) {
    }

}
