	.section .data
@n:
	.word 	0
@k:
	.word 	0
	.section .rodata
.str.0:
.asciz	">> "
	.text
	.globl	main
main:
.Lenter_main_0:
	addi	sp, sp, -148
	sw	ra, 0(sp)
	li	t0, 4
	sw	t0, 16(sp)
	lw	t2, 16(sp)
	add	t0, sp, t2
	sw	t0, 20(sp)
	li	t0, 8
	sw	t0, 24(sp)
	lw	t2, 24(sp)
	add	t0, sp, t2
	sw	t0, 28(sp)
	li	t0, 12
	sw	t0, 32(sp)
	lw	t2, 32(sp)
	add	t0, sp, t2
	sw	t0, 36(sp)
	li	t0, 0
	lw	t1, 36(sp)
	sw	t0, 0(t1)
	call	__mx_global_var_init
	li	t0, 79
	la	t0, @n
	sw	t0, 40(sp)
	lw	t1, 40(sp)
	sw	t0, 0(t1)
	la	t0, @n
	sw	t0, 44(sp)
	li	t0, 35
	lw	t1, 28(sp)
	sw	t0, 0(t1)
	li	t0, 12
	la	t0, @k
	sw	t0, 48(sp)
	lw	t1, 48(sp)
	sw	t0, 0(t1)
	la	t0, @k
	sw	t0, 52(sp)
	li	t0, 23
	lw	t1, 20(sp)
	sw	t0, 0(t1)
	j	.Lfor.cond_0

.Lfor.cond_0:
	lw	t1, 28(sp)
	lw	t0, 0(t1)
	sw	t0, 56(sp)
	la	t0, @k
	sw	t0, 60(sp)
	la	t0, @k
	sw	t0, 64(sp)
	lw	t1, 64(sp)
	lw	t0, 0(t1)
	sw	t0, 68(sp)
	lw	t1, 56(sp)
	lw	t2, 68(sp)
	add	t0, t1, t2
	sw	t0, 72(sp)
	lw	t1, 20(sp)
	lw	t0, 0(t1)
	sw	t0, 76(sp)
	lw	t1, 76(sp)
	lw	t2, 72(sp)
	slt	t0, t1, t2
	sb	t0, 80(sp)
	lb	t1, 80(sp)
	beqz	t1, .Lfor.end_0
	j	.Lfor.body_0

.Lfor.inc_0:
	lw	t1, 20(sp)
	lw	t0, 0(t1)
	sw	t0, 81(sp)
	li	t0, 1
	lw	t1, 81(sp)
	add	t0, t1, t0
	sw	t0, 85(sp)
	lw	t1, 20(sp)
	sw	t0, 0(t1)
	sw	t0, 85(sp)
	j	.Lfor.cond_0

.Lfor.body_0:
	j	.Lfor.inc_0

.Lfor.end_0:
	lw	t1, 28(sp)
	lw	t0, 0(t1)
	sw	t0, 89(sp)
	la	t0, @k
	sw	t0, 93(sp)
	la	t0, @k
	sw	t0, 97(sp)
	lw	t1, 97(sp)
	lw	t0, 0(t1)
	sw	t0, 101(sp)
	lw	t1, 89(sp)
	lw	t2, 101(sp)
	add	t0, t1, t2
	sw	t0, 105(sp)
	la	t0, @n
	sw	t0, 109(sp)
	la	t0, @n
	sw	t0, 113(sp)
	lw	t1, 113(sp)
	lw	t0, 0(t1)
	sw	t0, 117(sp)
	lw	t1, 105(sp)
	lw	t2, 117(sp)
	slt	t0, t1, t2
	sb	t0, 121(sp)
	lb	t1, 121(sp)
	beqz	t1, .Lif.end_0
	j	.Lif.then_0

.Lif.then_0:
	la	t0, .str.0
	sw	t0, 122(sp)
	lw	t1, 122(sp)
	mv	a0, t1
	call	print
	mv	t0, a0
	sb	t0, 126(sp)
	j	.Lif.end_0

.Lif.end_0:
	li	t0, 0
	lw	t1, 36(sp)
	sw	t0, 0(t1)
	j	.Lexit_main_0

.Lexit_main_0:
	lw	t1, 36(sp)
	lw	t0, 0(t1)
	sw	t0, 126(sp)
	lw	t1, 126(sp)
	mv	a0, t1
	lw	ra, 0(sp)
	addi	sp, sp, 148
	ret


	.text
	.globl	__mx_global_var_init
__mx_global_var_init:
.Lenter___mx_global_var_init_0:
	addi	sp, sp, -4
	sw	ra, 0(sp)
	j	.Lexit___mx_global_var_init_0

.Lexit___mx_global_var_init_0:
	lw	ra, 0(sp)
	addi	sp, sp, 4
	ret



