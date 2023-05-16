<div dir='rtl' align="center">
             
</br>   
<img src="https://s28.picofile.com/file/8462130392/uni.png"  width="250"/>

<h2>🔷 UNIVERSITY OF ISFAHAN 🔷</h2>
<h3>LANGUAGES AND AUTOMATA THEORY COURSE</h3>
              <h3>AUTHORS:</h3>
          <h3>MELIKA  SHIRIAN</h3>
          <h3>ZAHRA   MASOUMI</h3>
          <h3>KIANOOSH VADAEI</h3>
</div>


</br>
<h3> 🔴 for language { a^n b^m c^m : n,m >= 0 } </h3>
</br>

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
                                                             
