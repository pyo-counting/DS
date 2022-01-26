#ifndef __SINGLELIST_H__
#define __SINGLELIST_H__

#include <stdbool.h>

// SingleList Node
typedef struct	s_SListNode {
	struct s_SListNode* next;
	int					data;
}				t_SListNode;

// LinkedList Base
typedef struct	s_SListHeader {
	// member variable
	t_SListNode*	first;
	t_SListNode*	last;
	unsigned int	size;

	// member function
	bool (*empty)(struct s_SListHeader* self);
	void (*clear)(struct s_SListHeader* self);
}				t_SListHeader;

typedef struct	s_SList {
	t_SListHeader*	header;
}				SList;

// push, pop
void push_front(t_SListHeader*, int);
void push_back(t_SListHeader*, int);
void pop_front(t_SListHeader*);
void pop_back(t_SListHeader*);

// front, back
t_SListNode* front(SList*);
t_SListNode* back(SList*);

// New List, Header, Node
t_SListNode*	SListNodeNew(int);
t_SListHeader*	SListHeaderNew();
SList*			SListNew();

#endif