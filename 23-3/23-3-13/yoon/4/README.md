문제의 핵심
모든 두 원숭이에 대해서 적어도 한번은 적으로 만나도록 대진표 구성

결론적으로 N \* N 배열에 bool true로 완성되면 끝나긴함.

원숭이 수가 2라면
A B

원숭이 수가 4이라면
A A B B
=>
다음날 처리해야하는 경우는 1, 2번 원숭이 격리, 3, 4번 원숭이 격리
A B A B

원숭이 수가 8이라면
A A A A B B B B

A A B B A A B B

A B A B A B A B

원숭이 수가 6이라면
A A A B B B
A A B A A B
A B ? A B ?

?는 혹시라도 A B 중에 0인 팀 보내버려.
