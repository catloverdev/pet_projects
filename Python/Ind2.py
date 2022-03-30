#Задача о клике.
#Дан граф G с m вершинами и целое положительное число n. 
#Задача принятия решения: Найдется ли в данном графе G клика мощности не менее, чем n?

# function determines the neighbors of a given vertex
def n(vertex):
    c = 0
    l = []
    for i in new_graph[vertex]:
        if i == 1:
            l.append(c)
        c += 1
    return l

# the Bron-Kerbosch recursive algorithm
def bronk(r, p, x):
    if len(p) == 0 and len(x) == 0:
        self.__islands.append(r)  # в islands хранятся клики, список максимальных клик (всех)
        return
    for vertex in p[:]:
        r_new = r[::]
        r_new.append(vertex)
        p_new = [val for val in p if val in n(vertex)]  # p intersects N(vertex)
        x_new = [val for val in x if val in n(vertex)]  # x intersects N(vertex)
        bronk(r_new, p_new, x_new)
        p.remove(vertex)
        x.append(vertex)

	# вызывать вот так bronk([], list(range(len(self.__subject_list))), [])
	# на вход подать список вершин, от 0 до n, self.__subject_list - любой список размера n, т.е. число вершин