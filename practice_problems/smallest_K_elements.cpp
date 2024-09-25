#include <vector>
#include <queue>

using namespace std;

vector<int> smallestKElements(vector<int> &nums, int k)
{
    priority_queue<int> pq;

    for (int i = 0; i < nums.size(); i++)
    {
        if (pq.size() < k)
        {
            pq.push(nums[i]);
        }
        else if (nums[i] < pq.top())
        {
            pq.pop();
            pq.push(nums[i]);
        }
    }

    vector<int> result;
    while (!pq.empty())
    {
        result.push_back(pq.top());
        pq.pop();
    }

    return result;
}
