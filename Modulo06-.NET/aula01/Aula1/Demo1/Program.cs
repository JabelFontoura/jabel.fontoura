using System;
using System.Collections.Generic;

namespace Demo1
{
    class Program
    {
        static void Main(string[] args)
        {
            //var inputs = new List<int>();
            var inputs = new int[] { };
            var input = "";

            while (input != "exit")
            {
                Console.WriteLine("Digite um valor: ");
                input = Console.ReadLine();

                if (input == "exit") break;

                //inputs.Add(int.Parse(input));
                var auxInputs = new int[inputs.Length + 1];

                for (int i = 0; i < inputs.Length; i++)
                    auxInputs[i] = inputs[i];

                auxInputs[inputs.Length] = int.Parse(input);

                inputs = auxInputs;
            }

            foreach (var item in inputs)
                Console.WriteLine("Valor: " + item);

            Console.ReadKey();
        }
    }
}
