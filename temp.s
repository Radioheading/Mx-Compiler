	.section .rodata
.str.0:
.asciz	"\n"
	.text
	.globl	main
main:
.LBBenter_main_0:
	addi	sp, sp, -588
	sw	ra, 0(sp)
	li	%0, 4
	add	%1, sp, %0
	li	%2, 8
	add	%3, sp, %2
	li	%4, 12
	add	%5, sp, %4
	li	%6, 16
	add	%7, sp, %6
	li	%8, 20
	add	%9, sp, %8
	li	%10, 24
	add	%11, sp, %10
	li	%12, 28
	add	%13, sp, %12
	li	%14, 32
	add	%15, sp, %14
	li	%16, 0
	sw	%16, 0(%15)
	li	%17, 10000
	sw	%17, 0(%13)
	li	%18, 0
	sw	%18, 0(%11)
	li	%19, 2800
	sw	%19, 0(%9)
	li	%20, 0
	sw	%20, 0(%7)
	li	%21, 0
	sw	%21, 0(%5)
	li	%23, 2801
	li	%24, 4
	mul	%22, %23, %24
	li	%26, 4
	add	%25, %22, %26
	mv	a0, %25
	call	__malloc
	mv	%27, a0
	li	%28, 2801
	sw	%28, 0(%27)
	li	%30, 1
	slli	%31, %30, 2
	add	%29, %27, %31
	sw	%29, 0(%3)
	li	%32, 0
	sw	%32, 0(%1)
	li	%33, 0
	j	.LBBfor.cond_0

.LBBfor.cond_0:
	mv	%34, %33
	lw	%35, 0(%11)
	lw	%36, 0(%9)
	li	%38, 2800
	sub	%37, %34, %38
	li	%41, 0
	sub	%40, %37, %41
	snez	%39, %40
	beqz	%39, .LBBfor.end_0
	j	.LBBfor.body_0

.LBBfor.inc_0:
	lw	%42, 0(%11)
	li	%44, 1
	add	%43, %34, %44
	sw	%43, 0(%11)
	mv	%33, %43
	j	.LBBfor.cond_0

.LBBfor.body_0:
	lw	%45, 0(%3)
	lw	%46, 0(%11)
	slli	%48, %34, 2
	add	%47, %29, %48
	lw	%49, 0(%13)
	li	%51, 10000
	li	%52, 5
	div	%50, %51, %52
	sw	%50, 0(%47)
	j	.LBBfor.inc_0

.LBBfor.end_0:
	mv	%53, %34
	li	%54, 2800
	li	%55, 0
	li	%56, 0
	li	%57, 0
	j	.LBBfor.cond_1

.LBBfor.cond_1:
	mv	%58, %57
	mv	%59, %56
	mv	%60, %55
	mv	%61, %54
	mv	%62, %53
	j	.LBBfor.body_1

.LBBfor.inc_1:
	lw	%63, 0(%7)
	lw	%64, 0(%13)
	li	%67, 10000
	rem	%65, %66, %67
	sw	%65, 0(%5)
	mv	%53, %68
	mv	%54, %69
	mv	%55, %70
	mv	%56, %71
	mv	%57, %65
	j	.LBBfor.cond_1

.LBBfor.body_1:
	li	%72, 0
	sw	%72, 0(%7)
	lw	%73, 0(%9)
	li	%75, 2
	mul	%74, %61, %75
	sw	%74, 0(%1)
	lw	%76, 0(%1)
	li	%79, 0
	sub	%78, %74, %79
	seqz	%77, %78
	beqz	%77, .LBBif.end_0
	j	.LBBif.then_0

.LBBif.then_0:
	j	.LBBfor.end_1

.LBBif.end_0:
	lw	%80, 0(%9)
	sw	%61, 0(%11)
	mv	%81, %61
	mv	%82, %74
	li	%83, 0
	j	.LBBfor.cond_2

.LBBfor.cond_2:
	mv	%84, %83
	mv	%85, %82
	mv	%86, %81
	j	.LBBfor.body_2

.LBBfor.inc_2:
	lw	%87, 0(%7)
	lw	%88, 0(%11)
	mul	%89, %71, %68
	sw	%89, 0(%7)
	mv	%81, %68
	mv	%82, %70
	mv	%83, %89
	j	.LBBfor.cond_2

.LBBfor.body_2:
	lw	%90, 0(%3)
	lw	%91, 0(%11)
	slli	%93, %86, 2
	add	%92, %29, %93
	lw	%94, 0(%92)
	lw	%95, 0(%13)
	li	%97, 10000
	mul	%96, %94, %97
	lw	%98, 0(%7)
	add	%99, %84, %96
	sw	%99, 0(%7)
	lw	%100, 0(%3)
	lw	%101, 0(%11)
	slli	%103, %86, 2
	add	%102, %29, %103
	lw	%104, 0(%1)
	li	%106, 1
	sub	%105, %85, %106
	sw	%105, 0(%1)
	lw	%107, 0(%7)
	rem	%108, %99, %105
	sw	%108, 0(%102)
	lw	%109, 0(%7)
	lw	%110, 0(%1)
	div	%71, %99, %105
	sw	%71, 0(%7)
	lw	%111, 0(%1)
	li	%112, 1
	sub	%70, %105, %112
	sw	%70, 0(%1)
	lw	%113, 0(%11)
	li	%114, 1
	sub	%68, %86, %114
	sw	%68, 0(%11)
	li	%117, 0
	sub	%116, %68, %117
	seqz	%115, %116
	beqz	%115, .LBBif.end_1
	j	.LBBif.then_1

.LBBif.then_1:
	j	.LBBfor.end_2

.LBBif.end_1:
	j	.LBBfor.inc_2

.LBBfor.end_2:
	lw	%118, 0(%9)
	li	%119, 14
	sub	%69, %61, %119
	sw	%69, 0(%9)
	lw	%120, 0(%7)
	lw	%121, 0(%13)
	li	%123, 10000
	div	%122, %71, %123
	lw	%124, 0(%5)
	add	%125, %58, %122
	mv	a0, %125
	call	toString
	mv	%126, a0
	mv	a0, %126
	call	print
	mv	%127, a0
	j	.LBBfor.inc_1

.LBBfor.end_1:
	la	%128, .str.0
	mv	a0, %128
	call	print
	mv	%129, a0
	li	%130, 0
	sw	%130, 0(%15)
	j	.LBBexit_main_0

.LBBexit_main_0:
	lw	%131, 0(%15)
	li	%132, 0
	mv	a0, %132
	lw	ra, 0(sp)
	addi	sp, sp, 588
	ret



