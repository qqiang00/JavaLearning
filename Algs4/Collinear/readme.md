# GraderOutput

See the Assessment Guide for information on how to interpret this report.

Assessment Summary

Compilation:  PASSED
Checkstyle:   PASSED
Findbugs:     PASSED
API:          PASSED

Correctness:  41/41 tests passed
Memory:       1/1 tests passed
Timing:       40/41 tests passed

Aggregate score: 99.39% [Correctness: 65%, Memory: 10%, Timing: 25%, Style: 0%]

......

Test 4a-4g: Find collinear points among the N points on an N/8-by-8 grid

                                                      slopeTo()
             N    time     slopeTo()   compare()  + 2*compare()        compareTo()
-----------------------------------------------------------------------------------------------
=> passed    64   0.00        6806       15940          38686                  376         
=> passed   128   0.00       31852       72292         176436                  855         
=> passed   256   0.01      161773      249130         660033                 1975         
=> passed   512   0.02      920146      769004        2458154                 4485         
=> passed  1024   0.08     5864576     2897332       11659240                 9969         
=> passed  2048   0.45    40933017    11252102       63437221                22076         
=> passed  4096   2.79   303538598    44314047      392166692                48102         
==> 7/7 tests passed

lg ratio(slopeTo() + 2*compare()) = lg (392166692 / 63437221) = 2.63
=> FAILED (lg ratio is much greater than 2, your algorithm is probably cubic (or worse))

==> 7/8 tests passed

Total: 30/31 tests passed!


================================================================

