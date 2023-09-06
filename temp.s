	.section .data
@a:
	.word 	0
@m:
	.word 	0
@k:
	.word 	0
@i:
	.word 	0
	.text
	.globl	main
main:
.LBBenter_main_0:
	addi	sp, sp, -308
	sw	ra, 0(sp)
	call	__mx_global_var_init
	call	getInt
	mv	%0, a0
	la	%1, @m
	sw	%0, 0(%1)
	call	getInt
	mv	%2, a0
	la	%3, @k
	sw	%2, 0(%3)
	li	%4, 0
	la	%5, @i
	sw	%4, 0(%5)
	j	.LBBfor.cond_0

.LBBfor.cond_0:
	la	%7, @i
	lw	%6, 0(%7)
	la	%9, @m
	lw	%8, 0(%9)
	slt	%10, %6, %8
	beqz	%10, .LBBfor.end_0
	j	.LBBfor.body_0

.LBBfor.inc_0:
	la	%13, @i
	lw	%12, 0(%13)
	li	%15, 1
	add	%14, %12, %15
	la	%16, @i
	sw	%14, 0(%16)
	j	.LBBfor.cond_0

.LBBfor.body_0:
	la	%18, @a
	lw	%17, 0(%18)
	la	%20, @i
	lw	%19, 0(%20)
	slli	%22, %19, 2
	add	%21, %17, %22
	call	getInt
	mv	%23, a0
	sw	%23, 0(%21)
	j	.LBBfor.inc_0

.LBBfor.end_0:
	li	%24, 0
	la	%25, @i
	sw	%24, 0(%25)
	j	.LBBfor.cond_1

.LBBfor.cond_1:
	la	%27, @a
	lw	%26, 0(%27)
	la	%29, @i
	lw	%28, 0(%29)
	slli	%31, %28, 2
	add	%30, %26, %31
	la	%33, @k
	lw	%32, 0(%33)
	li	%35, 1
	sub	%34, %32, %35
	la	%37, @a
	lw	%36, 0(%37)
	slli	%39, %34, 2
	add	%38, %36, %39
	lw	%40, 0(%30)
	lw	%41, 0(%38)
	slt	%43, %40, %41
	xori	%42, %43, 1
	beqz	%42, .LBBshort.quick_0
	j	.LBBshort.rhs_0

.LBBshort.rhs_0:
	la	%45, @a
	lw	%44, 0(%45)
	la	%47, @i
	lw	%46, 0(%47)
	slli	%49, %46, 2
	add	%48, %44, %49
	lw	%50, 0(%48)
	li	%53, 0
	slt	%51, %53, %50
	mv	%54, %51
	mv	%55, %54
	j	.LBBshort.end_0

.LBBshort.quick_0:
	li	%55, 0
	j	.LBBshort.end_0

.LBBshort.end_0:
	mv	%56, %55
	mv	%57, %56
	beqz	%57, .LBBshort.quick_1
	j	.LBBshort.rhs_1

.LBBshort.rhs_1:
	la	%59, @i
	lw	%58, 0(%59)
	la	%61, @m
	lw	%60, 0(%61)
	slt	%62, %58, %60
	mv	%64, %62
	mv	%65, %64
	j	.LBBshort.end_1

.LBBshort.quick_1:
	li	%65, 0
	j	.LBBshort.end_1

.LBBshort.end_1:
	mv	%66, %65
	mv	%67, %66
	beqz	%67, .LBBfor.end_1
	j	.LBBfor.body_1

.LBBfor.inc_1:
	la	%69, @i
	lw	%68, 0(%69)
	li	%71, 1
	add	%70, %68, %71
	la	%72, @i
	sw	%70, 0(%72)
	j	.LBBfor.cond_1

.LBBfor.body_1:
	j	.LBBfor.inc_1

.LBBfor.end_1:
	la	%74, @i
	lw	%73, 0(%74)
	mv	a0, %73
	call	printInt
	mv	%75, a0
	j	.LBBexit_main_0

.LBBexit_main_0:
	li	%76, 0
	mv	a0, %76
	lw	ra, 0(sp)
	addi	sp, sp, 308
	ret


	.text
	.globl	__mx_global_var_init
__mx_global_var_init:
.LBBenter___mx_global_var_init_0:
	addi	sp, sp, -48
	sw	ra, 0(sp)
	li	%78, 50
	li	%79, 4
	mul	%77, %78, %79
	li	%81, 4
	add	%80, %77, %81
	mv	a0, %80
	call	__malloc
	mv	%82, a0
	li	%83, 50
	sw	%83, 0(%82)
	li	%85, 1
	slli	%86, %85, 2
	add	%84, %82, %86
	la	%87, @a
	sw	%84, 0(%87)
	j	.LBBexit___mx_global_var_init_0

.LBBexit___mx_global_var_init_0:
	lw	ra, 0(sp)
	addi	sp, sp, 48
	ret



