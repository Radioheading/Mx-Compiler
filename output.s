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
	mv	t0, a0
	sw	t0, 4(sp)
	la	t0, @m
	sw	t0, 8(sp)
	lw	t1, 8(sp)
	lw	t0, 4(sp)
	sw	t0, 0(t1)
	call	getInt
	mv	t0, a0
	sw	t0, 12(sp)
	la	t0, @k
	sw	t0, 16(sp)
	lw	t1, 16(sp)
	lw	t0, 12(sp)
	sw	t0, 0(t1)
	li	t0, 0
	sw	t0, 20(sp)
	la	t0, @i
	sw	t0, 24(sp)
	lw	t1, 24(sp)
	lw	t0, 20(sp)
	sw	t0, 0(t1)
	j	.LBBfor.cond_0

.LBBfor.cond_0:
	la	t0, @i
	sw	t0, 28(sp)
	lw	t1, 28(sp)
	lw	t0, 0(t1)
	sw	t0, 32(sp)
	la	t0, @m
	sw	t0, 36(sp)
	lw	t1, 36(sp)
	lw	t0, 0(t1)
	sw	t0, 40(sp)
	lw	t1, 32(sp)
	lw	t2, 40(sp)
	slt	t0, t1, t2
	sb	t0, 44(sp)
	lb	t1, 44(sp)
	beqz	t1, .LBBfor.end_0
	j	.LBBfor.body_0

.LBBfor.inc_0:
	la	t0, @i
	sw	t0, 45(sp)
	lw	t1, 45(sp)
	lw	t0, 0(t1)
	sw	t0, 49(sp)
	li	t0, 1
	sw	t0, 53(sp)
	lw	t1, 49(sp)
	lw	t2, 53(sp)
	add	t0, t1, t2
	sw	t0, 57(sp)
	la	t0, @i
	sw	t0, 61(sp)
	lw	t1, 61(sp)
	lw	t0, 57(sp)
	sw	t0, 0(t1)
	j	.LBBfor.cond_0

.LBBfor.body_0:
	la	t0, @a
	sw	t0, 65(sp)
	lw	t1, 65(sp)
	lw	t0, 0(t1)
	sw	t0, 69(sp)
	la	t0, @i
	sw	t0, 73(sp)
	lw	t1, 73(sp)
	lw	t0, 0(t1)
	sw	t0, 77(sp)
	lw	t1, 77(sp)
	slli	t0, t1, 2
	sw	t0, 81(sp)
	lw	t1, 69(sp)
	lw	t2, 81(sp)
	add	t0, t1, t2
	sw	t0, 85(sp)
	call	getInt
	mv	t0, a0
	sw	t0, 89(sp)
	lw	t1, 85(sp)
	lw	t0, 89(sp)
	sw	t0, 0(t1)
	j	.LBBfor.inc_0

.LBBfor.end_0:
	li	t0, 0
	sw	t0, 93(sp)
	la	t0, @i
	sw	t0, 97(sp)
	lw	t1, 97(sp)
	lw	t0, 93(sp)
	sw	t0, 0(t1)
	j	.LBBfor.cond_1

.LBBfor.cond_1:
	la	t0, @a
	sw	t0, 101(sp)
	lw	t1, 101(sp)
	lw	t0, 0(t1)
	sw	t0, 105(sp)
	la	t0, @i
	sw	t0, 109(sp)
	lw	t1, 109(sp)
	lw	t0, 0(t1)
	sw	t0, 113(sp)
	lw	t1, 113(sp)
	slli	t0, t1, 2
	sw	t0, 117(sp)
	lw	t1, 105(sp)
	lw	t2, 117(sp)
	add	t0, t1, t2
	sw	t0, 121(sp)
	la	t0, @k
	sw	t0, 125(sp)
	lw	t1, 125(sp)
	lw	t0, 0(t1)
	sw	t0, 129(sp)
	li	t0, 1
	sw	t0, 133(sp)
	lw	t1, 129(sp)
	lw	t2, 133(sp)
	sub	t0, t1, t2
	sw	t0, 137(sp)
	la	t0, @a
	sw	t0, 141(sp)
	lw	t1, 141(sp)
	lw	t0, 0(t1)
	sw	t0, 145(sp)
	lw	t1, 137(sp)
	slli	t0, t1, 2
	sw	t0, 149(sp)
	lw	t1, 145(sp)
	lw	t2, 149(sp)
	add	t0, t1, t2
	sw	t0, 153(sp)
	lw	t1, 121(sp)
	lw	t0, 0(t1)
	sw	t0, 157(sp)
	lw	t1, 153(sp)
	lw	t0, 0(t1)
	sw	t0, 161(sp)
	lw	t1, 157(sp)
	lw	t2, 161(sp)
	slt	t0, t1, t2
	sw	t0, 165(sp)
	lw	t1, 165(sp)
	xori	t0, t1, 1
	sb	t0, 169(sp)
	lb	t1, 169(sp)
	beqz	t1, .LBBshort.quick_0
	j	.LBBshort.rhs_0

.LBBshort.rhs_0:
	la	t0, @a
	sw	t0, 170(sp)
	lw	t1, 170(sp)
	lw	t0, 0(t1)
	sw	t0, 174(sp)
	la	t0, @i
	sw	t0, 178(sp)
	lw	t1, 178(sp)
	lw	t0, 0(t1)
	sw	t0, 182(sp)
	lw	t1, 182(sp)
	slli	t0, t1, 2
	sw	t0, 186(sp)
	lw	t1, 174(sp)
	lw	t2, 186(sp)
	add	t0, t1, t2
	sw	t0, 190(sp)
	lw	t1, 190(sp)
	lw	t0, 0(t1)
	sw	t0, 194(sp)
	li	t0, 0
	sw	t0, 198(sp)
	lw	t1, 198(sp)
	lw	t2, 194(sp)
	slt	t0, t1, t2
	sb	t0, 202(sp)
	lb	t1, 202(sp)
	mv	t0, t1
	sb	t0, 203(sp)
	lb	t1, 203(sp)
	mv	t0, t1
	sb	t0, 204(sp)
	j	.LBBshort.end_0

.LBBshort.quick_0:
	li	t0, 0
	sb	t0, 204(sp)
	j	.LBBshort.end_0

.LBBshort.end_0:
	lb	t1, 204(sp)
	mv	t0, t1
	sb	t0, 205(sp)
	lb	t1, 205(sp)
	mv	t0, t1
	sb	t0, 206(sp)
	lb	t1, 206(sp)
	beqz	t1, .LBBshort.quick_1
	j	.LBBshort.rhs_1

.LBBshort.rhs_1:
	la	t0, @i
	sw	t0, 207(sp)
	lw	t1, 207(sp)
	lw	t0, 0(t1)
	sw	t0, 211(sp)
	la	t0, @m
	sw	t0, 215(sp)
	lw	t1, 215(sp)
	lw	t0, 0(t1)
	sw	t0, 219(sp)
	lw	t1, 211(sp)
	lw	t2, 219(sp)
	slt	t0, t1, t2
	sb	t0, 223(sp)
	lb	t1, 223(sp)
	mv	t0, t1
	sb	t0, 224(sp)
	lb	t1, 224(sp)
	mv	t0, t1
	sb	t0, 225(sp)
	j	.LBBshort.end_1

.LBBshort.quick_1:
	li	t0, 0
	sb	t0, 225(sp)
	j	.LBBshort.end_1

.LBBshort.end_1:
	lb	t1, 225(sp)
	mv	t0, t1
	sb	t0, 226(sp)
	lb	t1, 226(sp)
	mv	t0, t1
	sb	t0, 227(sp)
	lb	t1, 227(sp)
	beqz	t1, .LBBfor.end_1
	j	.LBBfor.body_1

.LBBfor.inc_1:
	la	t0, @i
	sw	t0, 228(sp)
	lw	t1, 228(sp)
	lw	t0, 0(t1)
	sw	t0, 232(sp)
	li	t0, 1
	sw	t0, 236(sp)
	lw	t1, 232(sp)
	lw	t2, 236(sp)
	add	t0, t1, t2
	sw	t0, 240(sp)
	la	t0, @i
	sw	t0, 244(sp)
	lw	t1, 244(sp)
	lw	t0, 240(sp)
	sw	t0, 0(t1)
	j	.LBBfor.cond_1

.LBBfor.body_1:
	j	.LBBfor.inc_1

.LBBfor.end_1:
	la	t0, @i
	sw	t0, 248(sp)
	lw	t1, 248(sp)
	lw	t0, 0(t1)
	sw	t0, 252(sp)
	lw	t1, 252(sp)
	mv	a0, t1
	call	printInt
	mv	t0, a0
	sb	t0, 256(sp)
	j	.LBBexit_main_0

.LBBexit_main_0:
	li	t0, 0
	sw	t0, 256(sp)
	lw	t1, 256(sp)
	mv	a0, t1
	lw	ra, 0(sp)
	addi	sp, sp, 308
	ret


	.text
	.globl	__mx_global_var_init
__mx_global_var_init:
.LBBenter___mx_global_var_init_0:
	addi	sp, sp, -48
	sw	ra, 0(sp)
	li	t0, 50
	sw	t0, 4(sp)
	li	t0, 4
	sw	t0, 8(sp)
	lw	t1, 4(sp)
	lw	t2, 8(sp)
	mul	t0, t1, t2
	sw	t0, 12(sp)
	li	t0, 4
	sw	t0, 16(sp)
	lw	t1, 12(sp)
	lw	t2, 16(sp)
	add	t0, t1, t2
	sw	t0, 20(sp)
	lw	t1, 20(sp)
	mv	a0, t1
	call	__malloc
	mv	t0, a0
	sw	t0, 24(sp)
	li	t0, 50
	sw	t0, 28(sp)
	lw	t1, 24(sp)
	lw	t0, 28(sp)
	sw	t0, 0(t1)
	li	t0, 1
	sw	t0, 32(sp)
	lw	t1, 32(sp)
	slli	t0, t1, 2
	sw	t0, 36(sp)
	lw	t1, 24(sp)
	lw	t2, 36(sp)
	add	t0, t1, t2
	sw	t0, 40(sp)
	la	t0, @a
	sw	t0, 44(sp)
	lw	t1, 44(sp)
	lw	t0, 40(sp)
	sw	t0, 0(t1)
	j	.LBBexit___mx_global_var_init_0

.LBBexit___mx_global_var_init_0:
	lw	ra, 0(sp)
	addi	sp, sp, 48
	ret



