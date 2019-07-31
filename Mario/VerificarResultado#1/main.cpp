#include <iostream>
#include <cstdlib>

using namespace std;
void MD(int [], int [], int);
int main()
{
    int X[5] = {1,4,2,1,2};
    int C[5];
    MD(X,C,5);

    return 0;
}

void MD (int X[], int C[], int N){
for ( int i=0; i<N; i++){
    C[i]=1;
}
for (int i=0; i<N; i++){
    for (int j=0; j<N; j++){
        if (i!= j){
            if (X[i]== X[j]){
                C[j]++;
            }
        }
    }
}
for (int i=0; i<N; i++){
    cout<<" "<<C[i];
}
}
