

// Java parser for detecting python dependencies

// This s a BETA version

import java.util.Scanner;

import java.util.ArrayList;

public class java_python_parser_1{

	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);

		String test_dependencies = "import python import keras  dorandombullshit(int params) : int a = params print(a) import scipy import pandas "; //import keras import tensorflow and some random shit, then again import scipy import pandas";

		String[] dependencies_list_final = dependencies_acquire(test_dependencies);

		for(String string_element : dependencies_list_final)
		{
			System.out.println(string_element);
		}

		/*

		System.out.println();

		System.out.println(dependencies_list_final[3]);

		The indivual elements can be accessed too !!!

		*/
		
	}
	
	public static String[] dependencies_acquire(String test_dependencies)
	{
		String[] broken_string = test_dependencies.trim().split("\\s+", -1);  // splitting with space

		int no_of_dependencies = 0;

		String import_ref = "import";

		for(int i = 0; i < broken_string.length; i++)
		{
			if(import_ref.equals(broken_string[i]))   // this is how we should compare two strings
			{
				no_of_dependencies++;
			}
		}

		List dependencies_list = new ArrayList<String>();

		for(int i = 0; i < broken_string.length; i++)
		{
			if(import_ref.equals(broken_string[i]))
			{
				String temp_string = new String();

				temp_string = broken_string[i + 1];

				dependencies_list.add(temp_string);

				i++;

			}
		}

		String[] final_dependencies_array = (String[]) dependencies_list.toArray( new String[dependencies_list.size()]);  // conversion of a list back to a string array

		return final_dependencies_array;
	}
}