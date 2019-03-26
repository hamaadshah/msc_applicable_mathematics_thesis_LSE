// License
// Copyright 2007 Hamaad Musharaf Shah
// Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
// http://www.apache.org/licenses/LICENSE-2.0
// Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

import java.io.*;
import java.lang.*;
import java.util.*;

public class Identity extends Methods {

    public float d;

    public float e;

    public int[] Data;

    public float[] Y;

    public Identity(int[] I, float[] Y, float d, float e) {
        this.d = d;
        this.e = e;
        this.Y = Y;
        this.Data = I;
    }

    public Identity(float[] F, float[] Y, float d, float e) {
        float[] F_keys = Keys_table_float(F);
        int[] I_keys = new int[F_keys.length];

        int n = 0;

        for (int i = 0; i < I_keys.length; i++) {
            I_keys[i] = n;
            n++;
        }

        int[] I = new int[F.length];

        for (int i = 0; i < I.length; i++) {
            for (int j = 0; j < I_keys.length; j++) {
                if (F[i] == F_keys[j]) I[i] = I_keys[j];
            }
        }

        this.d = d;
        this.e = e;
        this.Y = Y;
        this.Data = I;
    }

    public Identity(String[] S, float[] Y, float d, float e) {
        String[] S_keys = Keys_table_string(S);

        int[] I_keys = new int[S_keys.length];

        int n = 0;

        for (int i = 0; i < I_keys.length; i++) {
            I_keys[i] = n;
            n++;
        }

        int[] I = new int[S.length];

        for (int i = 0; i < I.length; i++) {
            for (int j = 0; j < I_keys.length; j++) {
                if (S[i] == S_keys[j]) I[i] = I_keys[j];
            }
        }

        this.d = d;
        this.e = e;
        this.Y = Y;
        this.Data = I;
    }

    public String Identity() {
        String[] Trials = new String[Math.abs((int) Math.log(1.0 / d))];

        int[] Count = {0, 0};

        for (int z = 0; z < Trials.length; z++) {    // The result of the first block of tests.
            String Ans_1 = null;

            // The result of the second block of tests.
            String Ans_2 = null;

            int[] Keys = Keys_table_int(Data);

            int n = Keys.length;

            int k = (int) ((2 / Math.log(1 + e)) * (Math.log(n)));

            int[][] R = new int[k + 1][];

            for (int i = 0; i <= k; i++) {
                R[i] = Bucket(Y, (float) (e / Math.sqrt(2)), n, i);
            }

            int[][] MM = new int[k + 1][];

            int[] L = new int[k + 1];

            float[] x = new float[k + 1];

            float[] xx = new float[k + 1];

            float[] y = new float[k + 1];

            int[] M = Sample(Data,
                    (int) (Math.sqrt(n) * Math.pow(e, -2) * Math.log(n)));

            Output_file_int(M, "Identity.txt");

            for (int i = 0; i <= k; i++) {
                int[] temp = new int[R[i].length];

                for (int j = 0; j < R[i].length; j++) {
                    temp[j] = Keys[R[i][j]];
                }

                MM[i] = Intersect(M, temp);

                L[i] = MM[i].length;

                x[i] = (float) Self_col_prob(MM[i]);

                xx[i] = (float) (MM[i].length / M.length);

                for (int j = 0; j < R[i].length; j++) {
                    y[i] += Y[R[i][j]];
                }
            }

            List<String> Ans = new ArrayList<String>();

            String[] Result = {"Fail!", "Pass!"};

            // The first block of tests.
            for (int i = 0; i <= k; i++) {
                if (y[i] >= (float) (e / (float) k)) {
                    if (L[i] < (int) (Math.sqrt(n) * Math.pow(e, -2))) Ans.add(Result[0]);
                    else {
                        if (x[i] > (float) ((1 + Math.pow(e, 2)) / R[i].length)) Ans.add(Result[0]);
                        else Ans.add(Result[1]);
                    }
                }
            }

            String[] ANS = Ans.toArray(new String[0]);

            for (int i = 0; i < ANS.length; i++) {
                if (ANS[i] == Result[0]) Ans_1 = Result[0];
                else Ans_1 = Result[1];
            }

            int count = 0;

            // The second block of tests.
            for (int i = 0; i <= k; i++) {
                if ((y[i] < (float) ((1 - e) * (xx[i]))) || (y[i] > (float) ((1 + e) * (xx[i])))) count += 1;
                else count += 0;
            }

            if (count == k + 1) Ans_2 = Result[0];
            else Ans_2 = Result[1];

            if (Ans_1 == Result[1] && Ans_2 == Result[1]) Trials[z] = Result[1];
            else Trials[z] = Result[0];

            if (Trials[z] == Result[0]) Count[0] += 1;
            else Count[1] += 1;
        }

        if (Count[0] > Count[1]) return "Fail!";
        else return "Pass!";
    }

    public static void main(String[] args) {
    }

} 

