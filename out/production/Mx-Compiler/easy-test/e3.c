/*
Test Package: Codegen
Author: Pikachu
Time: 2020-02-02
Input:
=== input ===
1
=== end ===
Output:
=== output ===
NO
=== end ===
ExitCode: 0
InstLimit: -1
Origin Package: Codeforces 4A #57460997
*/
#include <stdio.h>
int main(){
int w;
scanf("%d",&w);
(w%2==0&&w>2)?printf("YES"):printf("NO");
}