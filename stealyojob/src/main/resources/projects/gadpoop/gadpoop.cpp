

#include <iostream>
#include <algorithm>

int findMin(int arr[], int len)
{
    int min = arr[0];
    for (int i = 0; i < len; i++)
    {
        min = std::min(min, arr[i]);
    }
    return min;
}


int main()
{
    int arr[] = {3, 8, 6, -4, 10};
    int min = findMin(arr, 5);
    std::cout << min;
    return 0;
}