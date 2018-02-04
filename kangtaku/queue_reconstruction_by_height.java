class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length,i;
        LinkedList<Person> pl = new LinkedList<>();
        Arrays.sort(people, (x, y) -> {
            if (x[0] != y[0]) return y[0] - x[0];
            else if (x[1] != y[1]) return x[1] - y[1];
            return 0;
        });
        for (i = 0; i < n; i++) {
            pl.add(people[i][1], new Person(people[i][0],people[i][1]));
        }
        for(i=0;i<n;i++){
            Person p = pl.poll();
            people[i][0]=p.h;
            people[i][1]=p.k;
        }
        return people;
    }
}

class Person {
    int h, k;
    Person(int h,int k){this.h=h;this.k=k;}
}
