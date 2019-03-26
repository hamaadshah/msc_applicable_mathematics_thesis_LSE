// License
// Copyright 2007 Hamaad Musharaf Shah
// Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
// http://www.apache.org/licenses/LICENSE-2.0
// Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

import java.io.*;
import java.lang.*;
import java.util.*;

public class Independence extends Methods {

    public float d;

    public float e;

    public int[][] A;

    public Independence(int[][] I, float d, float e) {
        this.d = d;
        this.e = e;
        this.A = I;
    }

    public Independence(float[][] F, float d, float e) {
        List<Float> F_keys_list = new ArrayList<Float>();

        for (int i = 0; i < F.length; i++) {
            F_keys_list.add(F[i][0]);
            F_keys_list.add(F[i][1]);
        }

        Float[] Temp_1 = F_keys_list.toArray(new Float[0]);
        float[] Temp_2 = new float[Temp_1.length];

        for (int i = 0; i < Temp_2.length; i++) {
            Temp_2[i] = Temp_1[i];
        }

        float[] F_keys = Keys_table_float(Temp_2);

        int[] I_keys = new int[F_keys.length];

        int n = 0;

        for (int i = 0; i < I_keys.length; i++) {
            I_keys[i] = n;
            n++;
        }

        int[][] I = new int[F.length][2];

        for (int i = 0; i < I.length; i++) {
            for (int j = 0; j < F_keys.length; j++) {
                if (F[i][0] == F_keys[j]) I[i][0] = I_keys[j];
            }
        }

        for (int i = 0; i < I.length; i++) {
            for (int j = 0; j < F_keys.length; j++) {
                if (F[i][1] == F_keys[j]) I[i][1] = I_keys[j];
            }
        }

        this.d = d;
        this.e = e;
        this.A = I;
    }

    public Independence(String[][] S, float d, float e) {
        List<String> S_keys_list = new ArrayList<String>();

        for (int i = 0; i < S.length; i++) {
            S_keys_list.add(S[i][0]);
            S_keys_list.add(S[i][1]);
        }

        String[] Temp = S_keys_list.toArray(new String[0]);

        String[] S_keys = Keys_table_string(Temp);

        int[] I_keys = new int[S_keys.length];

        int n = 0;

        for (int i = 0; i < I_keys.length; i++) {
            I_keys[i] = n;
            n++;
        }

        int[][] I = new int[S.length][2];

        for (int i = 0; i < I.length; i++) {
            for (int j = 0; j < S_keys.length; j++) {
                if (S[i][0] == S_keys[j]) I[i][0] = I_keys[j];
            }
        }

        for (int i = 0; i < I.length; i++) {
            for (int j = 0; j < S_keys.length; j++) {
                if (S[i][1] == S_keys[j]) I[i][1] = I_keys[j];
            }
        }

        this.d = d;
        this.e = e;
        this.A = I;
    }

    public static String L2_Test_for_Ind(int[][] A, long[] S_P, long[] S_Q, int m, float e, float d, String Type) {
        String[] Ans = new String[Math.abs((int) Math.log(1.0 / d))];

        int[] Count = {0, 0};

        for (int j = 0; j < Ans.length; j++) {
            if (Type == "Normal") {
                long[] F_p = conversion(joint_sample(A, m));
                long[] F_q = conversion(joint_ind_sample(A, m));
                long[] Q_p = conversion(joint_sample(A, m));
                long[] Q_q = conversion(joint_ind_sample(A, m));

                Output_file_long(F_p, "Independence_P.txt");
                Output_file_long(F_q, "Independence_Q.txt");

                int Self_Col_P = Self_col_prob_for_ind(F_p);
                int Self_Col_Q = Self_col_prob_for_ind(F_q);

                int Col_PQ = Col_prob_for_ind(Q_p, Q_q);

                float r = (float) (((2.0F * (float) m) / ((float) (m - 1.0F))) * (float) (Self_Col_P + Self_Col_Q));

                float s = (float) (2.0F * Col_PQ);

                String[] Result = {"Fail!", "Pass!"};

                if ((r - s) > (float) ((Math.pow(m, 2) * Math.pow(e, 2)) / 2.0F)) Ans[j] = Result[0];
                else Ans[j] = Result[1];

                if (Ans[j] == Result[0]) Count[0] += 1;
                else Count[1] += 1;
            } else {
                long[] F_p = Sample_light_for_ind_1(conversion(A), S_P, m);
                long[] F_q = Sample_light_for_ind_2(conversion(A), S_Q, A, m);
                long[] Q_p = Sample_light_for_ind_1(conversion(A), S_P, m);
                long[] Q_q = Sample_light_for_ind_2(conversion(A), S_Q, A, m);

                Output_file_long(F_p, "Independence_P.txt");
                Output_file_long(F_q, "Independence_Q.txt");

                int Self_Col_P = Self_col_prob_for_ind(F_p);
                int Self_Col_Q = Self_col_prob_for_ind(F_q);

                int Col_PQ = Col_prob_for_ind(Q_p, Q_q);

                float r = (float) (((2.0F * (float) m) / ((float) (m - 1.0F))) * (float) (Self_Col_P + Self_Col_Q));

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

    public String Ind() {
        Random generator = new Random();

        int n = Keys_table_long(conversion(A)).length;

        int m = (int) ((Math.pow(n, 2.0 / 3.0)) / (Math.pow(e, 4)));

        int M = (int) ((Math.max(Math.pow(e, -2), 4)) * (Math.pow(n, 2.0 / 3.0)) * (Math.log(n)));

        long[] Sample_P = conversion(joint_sample(A, M));
        long[] Sample_Q = conversion(joint_ind_sample(A, M));

        List<Long> S_P_temp = new ArrayList<Long>();
        List<Long> S_Q_temp = new ArrayList<Long>();

        for (int i = 0; i < Sample_P.length; i++) {
            if ((double) Freq_index_long(Sample_P, i) >= ((1.0F - (e / 63.0F)) * M * Math.pow(n, -2.0 / 3.0)))
                S_P_temp.add((long) Sample_P[i]);
        }

        for (int i = 0; i < Sample_Q.length; i++) {
            if ((double) Freq_index_long(Sample_Q, i) >= ((1.0F - (e / 63.0F)) * M * Math.pow(n, -2.0 / 3.0)))
                S_Q_temp.add((long) Sample_Q[i]);
        }

        Long[] X = S_P_temp.toArray(new Long[0]);
        Long[] Y = S_Q_temp.toArray(new Long[0]);

        long[] S_P = new long[X.length];
        long[] S_Q = new long[Y.length];

        for (int i = 0; i < S_P.length; i++) {
            S_P[i] = X[i];
        }

        for (int i = 0; i < S_Q.length; i++) {
            S_Q[i] = Y[i];
        }

        if (S_P_temp.isEmpty() == true && S_Q_temp.isEmpty() == true)
            return L2_Test_for_Ind(A, S_P, S_Q, m, (float) (e / (2.0F * Math.sqrt(n))), (float) (d / 2.0F), "Normal");
        else {
            List<Long> Common = new ArrayList<Long>();

            for (int i = 0; i < S_P.length; i++) {
                for (int j = 0; j < S_Q.length; j++) {
                    if (S_P[i] == S_Q[i]) Common.add((long) S_P[i]);
                }
            }

            Long[] Temp = Common.toArray(new Long[0]);

            long[] Common_elements = new long[Temp.length];

            for (int i = 0; i < Temp.length; i++) {
                Common_elements[i] = Temp[i];
            }

            List<Integer> L = new ArrayList<Integer>();

            for (int i = 0; i < Common_elements.length; i++) {
                L.add((int) ((Freq_element_long(S_P, Common_elements[i]) - Freq_element_long(S_Q, Common_elements[i]))));
            }

            Integer[] Temp_y = L.toArray(new Integer[0]);

            int L_count = 0;

            for (int i = 0; i < Temp_y.length; i++) {
                L_count += Temp_y[i];
            }

            if (((float) L_count) > ((e * M) / (float) 8)) return "Fail!!!";
            else {
                return L2_Test_for_Ind(A, S_P, S_Q, m, (float) (e / (2.0F * Math.sqrt(n))), (float) (d / 2.0F), "Light");
            }
        }
    }

    public static void main(String[] args) {
    }

}
