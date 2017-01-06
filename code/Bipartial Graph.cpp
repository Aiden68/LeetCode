#include<iostream>
#include<vector>
#include<queue>
using namespace std;

int main()
{
	int t;
	scanf("%d", &t);
	while(t--)
	{
		int n, m;
		vector<int> graph[10005];
		scanf("%d%d",&n, &m);
		for(int i = 0; i < m; i++)
		{
			int v1, v2;
			scanf("%d%d", &v1, &v2);
			graph[v1].push_back(v2);
			graph[v2].push_back(v1);
		}
		int visit[10005] = { 0 };
		bool isWrong = false;
		for(int j = 1; j <= n; j++)
		{
			if(visit[j] == 0)
			{
				visit[j] = 1;
				queue<int> q;
				q.push(1);
				while(!q.empty())
				{
					int v = q.front();
					q.pop();
					for(int i = 0; i < graph[v].size(); i++)
					{
						int temp = graph[v][i];
						if(visit[temp] == 0)
						{
							visit[temp] = visit[v] * (-1);
							q.push(temp);
						}
						else if(visit[temp] == visit[v])
						{
							isWrong = true;
							break;
						}
					}
					if(isWrong)
						break;
				}
			}
		}
		if(isWrong)
			printf("Wrong\n");
		else
			printf("Correct\n");
	}
	return 0;
}