package model;

public class HeapSort <T extends Comparable<T>> {
  

    public void sort(T[] arr) {
        int n = arr.length;

        // Construir el montículo (heapify)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extraer elementos uno por uno del montículo
        for (int i = n - 1; i >= 0; i--) {
            // Mover la raíz actual al final del arreglo
            T temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Llamar a heapify en el montículo reducido
            heapify(arr, i, 0);
        }
    }

    private void heapify(T[] arr, int n, int i) {
        int largest = i; // Inicializar el más grande como raíz
        int l = 2 * i + 1; // izquierda = 2*i + 1
        int r = 2 * i + 2; // derecha = 2*i + 2

        // Si el hijo izquierdo es más grande que la raíz
        if (l < n && arr[l].compareTo(arr[largest]) > 0) {
            largest = l;
        }

        // Si el hijo derecho es más grande que el más grande hasta ahora
        if (r < n && arr[r].compareTo(arr[largest]) > 0) {
            largest = r;
        }

        // Si el más grande no es la raíz
        if (largest != i) {
            T swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursivamente heapify el subárbol afectado
            heapify(arr, n, largest);
        }
    }
}
