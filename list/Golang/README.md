# **LinkedList - Golang**
## **Structure**
> ### **List**
> ```go
> type List struct {
> 	root Element
> 	len  int
> }
> ```
> ### **Element**
> ```go
> type Element struct {
> 	prev, next *Element
> 	list       *List
> 	Value      interface{}
> }
> ```
> ### **특이점**
> #### **Init method**
> ```go
> func (l *List) Init() *List {
> 	l.root.prev = &l.root
> 	l.root.next = &l.root
> 	l.len = 0
> 	return l
>  }
> ```
> `원형 연결리스트(Circular Linked list)`형태. \
> 각 비교조건에서 `root`인지에 대한 로직 필요.
> #### **Element struct의 list 멤버변수**
> ```go
>func (l *List) insert(e, at *Element) *Element {
>	e.prev = at
>	e.next = at.next
>	e.prev.next = e
>	e.next.prev = e
>	e.list = l
>	l.len++
>	return e
>}
>```
> 특정 `Element`가 어떤 리스트의 요소인지 확인가능. \
> C로 구현할때 참조할만한 부분.