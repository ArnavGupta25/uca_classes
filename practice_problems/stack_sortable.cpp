#include <bits/stdc++.h>
using namespace std;

bool check(int A[], int N)
{
    stack<int> S;
    int back = 0;

    for (int i = 0; i < N; i++)
    {
        if (!S.empty())
        {
            int top = S.top();

            while (top == back + 1)
            {
                back = back + 1;
                S.pop();
                if (S.empty())
                {
                    break;
                }
                top = S.top();
            }

            if (S.empty())
            {
                S.push(A[i]);
            }
            else
            {
                top = S.top();
                if (A[i] < top)
                {
                    S.push(A[i]);
                }
                else
                {
                    return false;
                }
            }
        }
        else
        {
            S.push(A[i]);
        }
    }
    return true;
}
