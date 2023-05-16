# PushDownAutomata


<h3> 🔴 for language { a^n b^m c^m : n,m >= 0 } </h3>

                                                    a , a ➝ a                b , λ ➝ b              c , b ➝ λ
                                                      ┌---┐                    ┌---┐                   ┌---┐
                                                      |   |                    |   |                   |   |
                                                      |   ⬇                    |   ⬇                   |   ⬇
    ┌────┐     λ , λ ➝ λ    ┌────┐     a , λ ➝ a    ┌────┐    b , a ➝ b     ┌────┐    c , b ➝ λ     ┌────┐
    │ q0 │-----------------➝│ q1 │-----------------➝│ q2 │-----------------➝│ q3 │-----------------➝│ q4 │
    └────┘                   └────┘                   └────┘                  └────┘                   └────┘
                                │                      │                        ⬆                         │
                                │                      │                        │                         │
                                └----------------------│------------------------┘                         │
                                                       │       b, λ ➝ b                                  │
                                                       │                                                  │
                                                       │                      ┌────┐                      │
                                                       └--------------------⟶│ q5 │⟵----------=---------┘
                                                              a , a ➝ λ      └────┘      λ , $ ➝ $
                                                              
             
<div dir='rtl' align="center">
             
</br>   
     -- UNIVERSITY OF ISFAHAN --
</br>
LANGUAGES AND AUTOMATA THEORY COURSE
</br>
              AUTHORS:
</br>
          MELIKA  SHIRIAN
</br>
          ZAHRA   MASOUMI
</br>
          KIANOOSH VADAEI
</div>
