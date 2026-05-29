#include<iostream>
#include<vector>

using namespace std;

vector<int> countingSort(vector<int> &arr, int exp){
    vector<int> count(10, 0); // Assuming values are in range 0-9
    for(int i = 0; i<arr.size(); i++){
        count[(arr[i]/exp)%10]++;
    }

    for(int i=0; i<9; i++){
        count[i+1] += count[i]; // Cumulative count
    }

    vector<int> output(arr.size());
    for(int i = arr.size() - 1; i>=0; i--){
        output[--count[(arr[i]/exp)%10]] = arr[i]; // Place the element in the output array and decrease the count
    }
    return output;
}

vector<int> radixSort(vector<int> &arr, int maxDigits){
    for(int i = 0, exp = 1; i < maxDigits; exp *= 10, i++){
        arr = countingSort(arr, exp);
    }
    return arr;
}

int main(){
    int t;
    cin >> t;
    while(t--){
        int n, maxDigits = 0;
        cin >> n;
        vector<int> arr(n);
        for(int i = 0; i<n; i++){
            cin >> arr[i];
            int digits = 0, temp = arr[i];
            while(temp>0){
                temp /= 10;
                digits++;                
            }
            if(digits > maxDigits){
                maxDigits = digits;
            }
        }
        vector<int> sorted = radixSort(arr, maxDigits);
        for(int i = 0; i<sorted.size(); i++){
            cout << sorted[i] << " ";
        }
        cout << endl;
    }
}