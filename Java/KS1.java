// License
// Copyright 2007 Hamaad Musharaf Shah
// Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
// http://www.apache.org/licenses/LICENSE-2.0
// Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

import java.io.*;
import java.lang.*;
import java.util.*;

public class KS1 extends Methods {

    public int[] Obs;

    public float[] Theo;

    public KS1(int[] I, float[] Theo) {
        this.Obs = I;
        this.Theo = Theo;
    }

    public KS1(float[] F, float[] Theo) {
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

        this.Obs = I;
        this.Theo = Theo;
    }

    public KS1(String[] S, float[] Theo) {
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

        this.Obs = I;
        this.Theo = Theo;
    }

    public double KS1() {
        int[] Cumulative_freq = Cumulative_freq(Obs);

        int n = Obs.length;

        float[] CDF = CDF(Cumulative_freq, n);

        double[] D = new double[CDF.length];

        for (int i = 0; i < D.length; i++) {
            D[i] = (double) Math.abs(Theo[i] - CDF[i]);
        }

        double K = Max(D);

        return K;
    }

    public static void main(String[] args) {
    }

}
