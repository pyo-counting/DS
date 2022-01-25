#ifndef __DOUBLELIST_H__
#define __DOUBLELIST_H__

#include <stdbool.h>

typedef struct	s_DListNode {
	struct s_DListNode* prev;
	struct s_DListNode* next;
	int					data;
}				t_DListNode;

typedef struct	s_DListHeader {
	// member variable
	t_DListNode*	first;
	t_DListNode*	last;
	unsigned int	size;

	// member function
	bool (*empty)(struct s_DListHeader*);
}				t_DListHeader;

// push, pop
void push_front(t_DListHeader*, int);
void push_back(t_DListHeader*, int);
void pop_front(t_DListHeader*);
void pop_back(t_DListHeader*);

// front, back
int front(t_DListHeader*);
int back(t_DListHeader*);

// New Node, Header
t_DListNode*	DListNodeNew(int);
t_DListHeader*	DListHeadNew();

#endif