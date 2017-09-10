package com.sleepyowl.sorting;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import java.util.Arrays;


public class SortingFragment extends Fragment {
    public TextView tv;
    public TextView tv1;
    public TextView tv2;
    Button bt3;
    Button bt4;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View s= inflater.inflate(R.layout.fragment_sorting, container, false);
        Bundle bundle = getArguments();
        String yournum= bundle.getString("Key");
        tv1= (TextView)s.findViewById(R.id.fillText);
        tv1.setText(yournum);

        tv = (TextView) s.findViewById(R.id.sort_tv);
        bt3=(Button)s.findViewById(R.id.button3);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuickSort(s);
            }
        });
        tv2 = (TextView) s.findViewById(R.id.merge_tv);
        bt4=(Button)s.findViewById(R.id.button4);
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MergeSort(s);
            }
        });

        return s;
    }

     public  void QuickSort(View s) {
            String str = tv1.getText().toString();
            String[] xyz = str.split(" ");
            int[] items = new int[xyz.length];
            for (int i = 0; i < xyz.length; i++) {
                try {
                    items[i] = Integer.parseInt(xyz[i]);
                } catch (NumberFormatException nfe) {
                    /* Rajeev Ranjan Mishra */
                };
            }
            sort(items);
        }

        public  void sort(int[] items) {
            if (items == null || items.length <= 0) {
                return;
            }

            quickSort(items, 0, items.length - 1);
            String testString = Arrays.toString(items);
            tv.setText(testString);


        }

        public  void quickSort(int items[], int start, int end) {
            if (start >= end) {
                return;
            }

            int pivot = partition(items, start, end);

            if (start < pivot - 1) {
                quickSort(items, start, pivot - 1);
            }

            if (end > pivot) {

                quickSort(items, pivot, end);
            }


        }


        private  int partition(int[] items, int start, int end) {

            int pivot = items[(start + end) / 2];
            while (start <= end) {
                while (items[start] < pivot) {
                    start++;
                }
                while (items[end] > pivot) {
                    end--;
                }

                if (start <= end) {
                    swap(items, start, end);
                    start++;
                    end--;
                }
            }
            return start;

        }


        private  void swap(int[] array, int firstIndex, int secondIndex) {
            if (array == null || firstIndex < 0 || firstIndex > array.length
                    || secondIndex < 0 || secondIndex > array.length) {
                return;
            }
            int temp = array[firstIndex];
            array[firstIndex] = array[secondIndex];
            array[secondIndex] = temp;

        }


        public  void MergeSort (View s) {

            String str = tv1.getText().toString();
            String[] xyz = str.split(" ");
            int[] numberArray = new int[xyz.length];
            for (int i = 0; i < xyz.length; i++) {
                try {
                    numberArray[i] = Integer.parseInt(xyz[i]);
                } catch (NumberFormatException nfe) {
                    /* Rajeev Ranjan Mishra */
                };
            }
            sortt(numberArray);


        }

        private  void sortt(int[] numberArray) {

            int[] tempArray = new int[numberArray.length];

            mergeSort(numberArray, tempArray, 0, numberArray.length - 1);

            String testString = Arrays.toString(numberArray);
            tv2.setText(testString);

        }

        private  void mergeSort(int[] data, int[] tempArray, int low, int high) {

            if (low < high) {

                int middle = (low + high) / 2;

                mergeSort(data, tempArray, low, middle);


                mergeSort(data, tempArray, middle + 1, high);

                merge(data, tempArray, low, middle, high);
            }
        }


        private  void merge(int[] data, int[] tempArray, int low, int middle, int high) {


            for (int i = low; i <= high; i++) {
                tempArray[i] = data[i];
            }

            int i = low;
            int j = middle + 1;
            int k = low;


            while (i <= middle && j <= high) {
                if (tempArray[i] <= tempArray[j]) {
                    data[k] = tempArray[i];
                    i++;
                } else {
                    data[k] = tempArray[j];
                    j++;
                }
                k++;
            }

            while (i <= middle) {
                data[k] = tempArray[i];
                k++;
                i++;
            }

        }






    }





