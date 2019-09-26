// this has the code for finding shortest distance in a directed graph with -ve edges as well
#include<bits/stdc++.h>
using namespace std;
typedef struct Graph
{
	int v;
	int e;
	int **adj;
}graph;
graph* adjMatrix()
{
	graph *G = (graph *)malloc(sizeof(graph));
	printf("enter number of vertices and edges ");
	int i,v,e;
	scanf("%d %d",&v,&e);
	G->e = e;
	G->v = v;
	G->adj = (int **)malloc(sizeof(G->v)* sizeof(int *));
	for(i=0;i<v;++i)
	{
		printf("printing %d\n ",i);
		G->adj[i] = (int *)malloc(sizeof(G->v));
	}
	//G->adj = (int **)malloc(sizeof(G->v * G->v));
	printf("printing \n ");
	for(e=0;e<G->v;++e)
	{
		for(v=0;v<G->v;++v)	
		{
			printf("assigning e %d ,v %d \n ",e,v);
			G->adj[e][v] =INT_MIN;
		}
	}
	for(e=0;e<G->v;++e)
	{
		for(v=0;v<G->v;++v)	
		{
			printf("%d ",G->adj [e][v]);
		}
		printf("\n");
	}
	printf("num edges = %d",G->e);
	for(e=0;e<G->e;++e)
	{
		int weight;
		scanf("%d%d",&i,&v);
		printf("enter weight \n");
		scanf("%d",&weight);
		printf("values of i %d and v %d adn weight is %d",i,v,weight);
		G->adj[i-1][v-1] =weight;
		//G->adj[v-1][i-1] =weight;
	}
	return G;
}
void bellman(graph *g,int vertex)
{
	printf("in ebellman");
	queue<int> que;
	int i;
	int distance[g->v];
	int present[g->v];
	for(i=0;i<g->v;++i)
	{
		distance[i] =INT_MAX;
		present[i] =0;
	}
	distance[vertex-1] =0;
	que.push(vertex-1);
	present[vertex-1] =1;
	printf("the crureent values ar e \n");
	for(int e=0;e<g->v;++e)
	{
		for(int v=0;v<g->v;++v)	
		{
			printf("%d ",g->adj[e][v]);
		}
		printf("\n");
	}
	printf("the values of disntaces and present \n");\
	for(int i=0;i<g->v;++i)
	{
		printf("%d %d \n",distance[i],present[i]);
	}
	while(!que.empty())
	{
		int top = que.front();
		que.pop();
		present[top] =0;
		for(int i=0;i<g->v;++i)
		{
			printf("ther value of top is %d \n",top);
			if(g->adj[i][top] != INT_MIN)
			{
				int dist = distance[top] + g->adj[i][top];
				printf("the values are %d and %d \n",distance[i],dist);
				
				if(distance[i] > dist)
				{
					printf("the cureent values are %d %d and %d \n",i,distance[i],dist);
					distance[i] = dist;
					if(present[i] == 0 )
					{
						printf("pushing i %d t o queu\n",i);
						que.push(i);
						present[i] =1;
					}
					
				}
				
				
			}		
		}
		printf("the rpresent materic right now is \n");
		for(int i=0;i<g->v;++i)
	{
		printf("%d \n",present[i]);
	}
	}
	printf("the distances are \n");
	for(int i=0;i<g->v;++i)
	{
		printf("%d ",distance[i]);
	}
	return;
}

void bellmanford(graph *g,int vertex)
{
	printf("in ebellman");
	queue<int> que;
	int i;
	int distance[g->v];
	int present[g->v];
	for(i=0;i<g->v;++i)
	{
		distance[i] =INT_MAX;
		present[i] =0;
	}
	distance[vertex-1] =0;
	que.push(vertex-1);
	present[vertex-1] =1;
	printf("the crureent values ar e \n");
	for(int e=0;e<g->v;++e)
	{
		for(int v=0;v<g->v;++v)	
		{
			printf("%d ",g->adj[e][v]);
		}
		printf("\n");
	}
	printf("the values of disntaces and present \n");\
	for(int i=0;i<g->v;++i)
	{
		printf("%d %d \n",distance[i],present[i]);
	}
	while(!que.empty())
	{
		int top = vertex -1;
		//int top = que.front();
		//que.pop();
		present[top] =0;
		for(int i=0;i<g->v;++i)
		{
			printf("ther value of top is %d \n",top);
			if(g->adj[i][top] != INT_MIN)
			{
				int dist = distance[top] + g->adj[i][top];
				printf("the values are %d and %d \n",distance[i],dist);
				
				if(distance[i] > dist)
				{
					printf("the cureent values are %d %d and %d \n",i,distance[i],dist);
					distance[i] = dist;
					if(present[i] == 0 )
					{
						printf("pushing i %d t o queu\n",i);
						que.push(i);
						present[i] =1;
					}
					
				}
				
				
			}		
		}
		printf("the rpresent materic right now is \n");
		for(int i=0;i<g->v;++i)
	{
		printf("%d \n",present[i]);
	}
	}
	printf("the distances are \n");
	for(int i=0;i<g->v;++i)
	{
		printf("%d ",distance[i]);
	}
	return;
}
int main()
{
	graph *g = adjMatrix();
	printf("the elemesnt are \n");
	for(int i=0;i<g->v;++i)
	{
		for(int j=0;j<g->v;++j)
		{
			printf("%d ",g->adj[i][j]);
		}
		printf("\n");
	}	
	bellman(g,1);
	return 0;
}