package slist

// struct

type List struct {
	head Element
	len  int
}

func New() *List {
	return new(List)
}

func (l *List) Init() *List {
	l.head.next = &l.head
	l.len = 0
	return l
}

func (l *List) Front() *Element {
	if l.len == 0 {
		return nil
	}
	return l.head.next
}

func (l *List) Back() *Element {
	cur := l.head.next
	if l.len == 0 {
		return nil
	}
	for cur.next != &l.head {
		cur = cur.Next()
	}
	return cur
}

func (l *List) Push_front(v interface{}) *Element {
	l.lazyInit()
	return l.insertValue(v, &l.head)
}

func (l *List) Push_back(v interface{}) *Element {
	l.lazyInit()
	return l.insertValue(v, l.Back())
}

func (l *List) Pop_front() interface{} {
	e := l.remove(&l.head, l.head.next)
	return e.Value
}

func (l *List) Pop_back() interface{} {
	prev := l.head.next
	at := l.Back()
	for prev.next != at {
		prev = prev.Next()
	}
	e := l.remove(prev, at)
	return e.Value
}

func (l *List) Insert(e, at *Element) *Element {
	return l.insert(e, at)
}

func (l *List) Remove(at *Element) *Element {
	prev := &l.head
	for prev.next != at {
		prev.Next()
	}
	return at
}
