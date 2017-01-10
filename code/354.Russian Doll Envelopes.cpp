/*刚开始没想到DP
**先是DFS,再BFS
**不出意外的超时了。。
**
*/

#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
using namespace std;


class Solution {
public:
	static bool com(pair<int, int> v1, pair<int, int> v2)
	{
		if(v1.first != v2.first)
			return v1.first < v2.first;
		else
			return v1.second < v2.second;
	}

	int dfs(int s, bool visit[],vector<int>* v)
	{
		int deep = 1;
		visit[s] = true;
		for(int i = 0; i < v[s].size(); i++)
		{
			if(visit[v[s][i]] == false)
			{
				int tdeep = dfs(v[s][i], visit, v) + 1;
				if(deep < tdeep)
					deep = tdeep;
			}
		}
		return deep;
	}

	int bfs(int s,vector<int>* v, int size, int indegree[])
	{
		int* deep = new int[size];
		fill(deep, deep + size, 1);
		int maxdeep = 1;
		queue<int> q;
		q.push(s);
		while(!q.empty())
		{
			s = q.front();
			q.pop();
			for(int i = 0; i < v[s].size(); i++)
			{
				if(deep[v[s][i]] < deep[s] + 1)
				{
					/*if(indegree[s] == 0)
						indegree[v[s][i]]--;*/
					deep[v[s][i]] = deep[s] + 1;
					if(maxdeep < deep[v[s][i]])
						maxdeep = deep[v[s][i]];
					q.push(v[s][i]);
				}
			}
		}
		return maxdeep;
	}
    int maxEnvelopes(vector<pair<int, int>>& envelopes) {
		int maxroll = 0;
		int size = envelopes.size();
		sort(envelopes.begin(),envelopes.end(),com);
		vector<int>* v = new vector<int>[size + 1];
		int *indegree = new int[size + 1];
		fill(indegree, indegree + size + 1, 0);
		bool* visit = new bool[size];
		int* deep = new int[size];
		fill(visit, visit + size, false);
		fill(deep, deep + size, 1);
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				if(envelopes[i].first < envelopes[j].first && envelopes[i].second < envelopes[j].second)
				{
					deep[j] = max(deep[i] + 1,deep[j]);
				}
			}
			
		}
		for(int i = 0; i < size; i++)
		{
			if(maxroll < deep[i])
				maxroll = deep[i];
		}
		/*for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < v[i].size(); j++)
			{
				if(deep[v[i][j]] < deep[i] + 1)
					deep[v[i][j]] = deep[i] + 1;
			}	
		}
		for(int i = 0; i < size; i++)
		{
			if(maxroll < deep[i])
				maxroll = deep[i];
		}*/
		return maxroll;
    }
};


int main()
{
	Solution s = Solution();
	vector<pair<int, int>> e;
	e.push_back(pair<int, int>(5,4));
	e.push_back(pair<int, int>(6,4));
	e.push_back(pair<int, int>(6,7));
	e.push_back(pair<int, int>(2,3));
	cout<<s.maxEnvelopes(e);
	return 0;
}