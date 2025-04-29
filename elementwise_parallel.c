#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <omp.h>

// Function to perform element-wise addition of two arrays
void addarray(int A[], int B[], int n) {
    int Result[n];
    //printf("\nThe sum of the arrays is: ");
    #pragma omp parallel for
    for (int i = 0; i < n; i++) {
        Result[i] = A[i] + B[i];
        //printf("%d ", Result[i]);
    }
    printf("\n");
}

// Function to perform element-wise subtraction of two arrays
void subarray(int A[], int B[], int n) {
    int Result[n];
    //printf("The subtraction of the arrays is: ");
    #pragma omp parallel for
    for (int i = 0; i < n; i++) {
        Result[i] = A[i] - B[i];
        //printf("%d ", Result[i]);
    }
    printf("\n");
}

// Function to perform element-wise multiplication of two arrays
void mularray(int A[], int B[], int n) {
    int Result[n];
    //printf("The multiplication of the arrays is: ");
    #pragma omp parallel for
    for (int i = 0; i < n; i++) {
        Result[i] = A[i] * B[i];
        //printf("%d ", Result[i]);
    }
    printf("\n");
}

int main() {
    int n;
    
    // Taking input from user for number of elements
    printf("Enter the number of elements: ");
    scanf("%d", &n);

    // Declaring two arrays of size n
    int *A = (int *)malloc(n * sizeof(int));
    int *B = (int *)malloc(n * sizeof(int));

    if (A == NULL || B == NULL) {
    printf("Memory allocation failed!\n");
    return 1;
    }


    // Seeding random number generator
    srand(time(NULL));

    // Initializing arrays A and B with random numbers between 0 and 9
    for (int i = 0; i < n; i++) {
        A[i] = rand() % 10;
        B[i] = rand() % 10;
    }

    // Displaying array A
    /*printf("Array A: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", A[i]);}
    
    printf("\n");

    // Displaying array B
    printf("Array B: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", B[i]);}
    
    printf("\n");*/

    // Recording start time
    double start = clock();
    // Performing element-wise operations
    addarray(A, B, n);
    subarray(A, B, n);
    mularray(A, B, n);

    // Recording end time
    double end = clock();
    
    // Calculating and displaying time taken
    double time_taken = (double)(end - start) / CLOCKS_PER_SEC;
    printf("Time taken is: %.5f seconds\n", time_taken);

    // Freeing allocated memory
    free(A);
    free(B);

    return 0;
}
