#include <iostream>
#include <queue>
#include <vector>

using namespace std;

class MedianFinder
{
    priority_queue<int> maxHeap;                            // Max heap for the lower half
    priority_queue<int, vector<int>, greater<int>> minHeap; // Min heap for the upper half

public:
    void addNum(int num)
    {
        if (maxHeap.empty() || num <= maxHeap.top())
        {
            maxHeap.push(num);
        }
        else
        {
            minHeap.push(num);
        }

        if (maxHeap.size() > minHeap.size() + 1)
        {
            minHeap.push(maxHeap.top());
            maxHeap.pop();
        }
        else if (minHeap.size() > maxHeap.size())
        {
            maxHeap.push(minHeap.top());
            minHeap.pop();
        }
    }

    double findMedian()
    {
        if (maxHeap.size() > minHeap.size())
        {
            return maxHeap.top();
        }
        else if (maxHeap.size() < minHeap.size())
        {
            return minHeap.top();
        }
        else
        {
            return (maxHeap.top() + minHeap.top()) / 2.0;
        }
    }
};

int main()
{
    MedianFinder mf;

    vector<int> stream = {5, 15, 1, 3};
    for (int i = 0; i < stream.size(); i++)
    {
        mf.addNum(stream[i]);
        cout << "Current median: " << mf.findMedian() << endl;
    }

    return 0;
}
