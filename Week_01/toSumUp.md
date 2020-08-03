## 总结：

学习算法第一周，总的感觉还不错，但是呢，时间规划的不是很合理，导致每天的东西学不完，时间不够用，尽管我每天花费的时间是2到3个小时，但还是感觉
时间不够。不过虽然这样，但感觉还是收获慢慢，有感觉了，就是那个feel。

说说干了啥把！前三天看了第三节课，然后实战了三个，也就是week_01的内容，不过只练了三道，之后基本每天一道算法题，也就是刷题狂魔组中的练习题，我
总感觉这个好，因为**每天都有明确的目标**，看视频没有非常明确的目标，果然目标更加明确，习惯才会得以形成，思想才会变成实践。

附上在做题过程中的总结（对于题目来说，都是刷了两遍）：

- https://github.com/MissWangLove/algorithm013/blob/master/Week_01/README.md （第一周实践的一些题目思考以及总结，这周的少）
- https://github.com/MissWangLove/algorithm013/blob/master/OneQuestionPerDay/README.md （每日一道题的题目思考和总结）
- https://github.com/MissWangLove/algorithm013/blob/master/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E4%B8%8E%E7%AE%97%E6%B3%95.xmind （思维导图的总结）

### 部分作业（部分作业在每日一练中，这里就不复制粘贴了）：

对于Queue和Priority Queue分析：

#### Queue

Queue在Java中是一个接口，接口提供的方法分为了三类： 插入、删除和查询（废话，所有的数据结构不都是提供者三类方法吗？）。

说说插入，分为两类： 一类是add，一类就是offer，区别在于前者在队列已满的情况下会抛出异常，后者的话会返回false；在实际的实践过程中，应当尽量使用
offer，而不是add。

说说删除： remove和poll，区别差不多，前者在队列为空的情况下抛出异常，后者会返回null。

说说查询： elements和peek，前者在队列为空的情况下抛出异常，后者则会返回null。

说在删除和查询，删除和查询都会返回当前的符合条件的元素，区别在于删除的话会删除队列中的元素，查询的话则不会。

实现类LinkedList的实现：

实现的基础结构是内部类Node，包括了前驱结点和后继结点，由于是双端队列的实现，所以实现会单独声明两个结点，分别是first和last，用来保存链表的第一个
结点和最后一个结点，还有一个就是数据结构基本都有的size，长度。接下来说实现的方法，方法的包括了Queue的基本实现，还有了Deque的全部实现，Deque无非
多的就是addFirst、addLast、peelFirst、peekLast等等，对于首尾结点的操作，其中的对于首尾元素的增删调用的私有的方法unlink和link方法。

增加方法分为了两大类：一类是在首尾的增加，一类是在某个元素之前的增加，分别是linkFirst，linkLast以及linkBefore。删除方法也类似，不过底层的实现
无非就是node结点的next和pre的转换，这个还算容易理解，面向对象的理解。

只需要记住首尾结点就可以找到所有的结点。

#### Priority Queue

优先队列，底层的实现依靠的是Object数组和Comparator比较器。不指定长度，默认长度为11。

增加：在这里add底层调用的是offer，返回的是boolean类型，里面有扩容机制，当最小容量小于64时，容量增加为原来的2倍，大于64时，容量变为原来的1.5倍。

移除：remove和removeEq操作，前者需要先判断队列中有无此元素，返回元素在队列中的索引，根据索引删除，后者不用判断，也就是说如果已经确定元素在队列
中存在，请使用后者，而非前者，性能会更好。

出对列： peek操作返回队列头部的元素。

遍历的话请使用迭代器。

实践还是太少，本来今天还打算再刷几道题，可是还有个工作的demo要写，如果晚上还有空余的时间，那就再刷几道题，如果没有就放到下周，继续加油。



