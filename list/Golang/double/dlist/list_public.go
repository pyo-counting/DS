package dlist

// struct
type List struct {
	root Element
	len  int
}

/*-------------------
public function - New
-------------------*/
func New() *List {
	return new(List).Init()
}

// public method
func (l *List) Init() *List {
	l.root.prev = &l.root
	l.root.next = &l.root
	l.len = 0
	return l
}

func (l *List) Front() *Element {
	if l.len == 0 {
		return nil
	}
	return l.root.next
}

func (l *List) Back() *Element {
	if l.len == 0 {
		return nil
	}
	return l.root.prev
}

func (l *List) Push_front(v interface{}) *Element {
	l.lazyInit()
	return l.insertValue(v, &l.root)
}

func (l *List) Push_back(v interface{}) *Element {
	l.lazyInit()
	return l.insertValue(v, l.root.prev)
}

func (l *List) Pop_front() interface{} {
	e := l.remove(l.root.next)
	return e.Value
}

func (l *List) Pop_back() interface{} {
	e := l.remove(l.root.prev)
	return e.Value
}
