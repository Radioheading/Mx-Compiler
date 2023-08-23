	.section .data
@n:
	.word 	0
@p:
	.word 	0
@k:
	.word 	0
@i:
	.word 	0
	.section .rodata
.str.0:
	"<< "
.str.3:
	" "
.str.4:
	">> "
.str.2:
	") "
.str.1:
	"("
.text
	.globl
main:
.Lenter_main_0:
	addi	%sp, %sp, -74
	sw	%ra, 0(%sp)
	sw	%t0, 0(%zero)
	sw	%t0, 12(%sp)
	call	__mx_global_var_init
	li	%t0, 4
	sw	%t0, 16(%sp)
	lw	%t2, 16(%sp)
	add	%t0, %sp, %t2
	sw	%t0, 4(%sp)
	li	%t0, 8
	sw	%t0, 20(%sp)
	lw	%t2, 20(%sp)
	add	%t0, %sp, %t2
	sw	%t0, 8(%sp)
	call	getInt
	mv	%t0, %ra
	sw	%t0, 24(%sp)
	la	%t0, @n
	sw	%t0, 28(%sp)
	lw	%t1, 24(%sp)
	sw	%t0, 0(%t1)
	sw	%t0, 28(%sp)
	la	%t0, @n
	sw	%t0, 32(%sp)
	call	getInt
	mv	%t0, %ra
	sw	%t0, 36(%sp)
	la	%t0, @p
	sw	%t0, 40(%sp)
	lw	%t1, 36(%sp)
	sw	%t0, 0(%t1)
	sw	%t0, 40(%sp)
	la	%t0, @p
	sw	%t0, 44(%sp)
	call	getInt
	mv	%t0, %ra
	sw	%t0, 48(%sp)
	la	%t0, @k
	sw	%t0, 52(%sp)
	lw	%t1, 48(%sp)
	sw	%t0, 0(%t1)
	sw	%t0, 52(%sp)
	la	%t0, @k
	sw	%t0, 56(%sp)
	lw	%t1, 44(%sp)
	lw	%t0, 0(%t1)
	sw	%t0, 44(%sp)
	lw	%t1, 56(%sp)
	lw	%t0, 0(%t1)
	sw	%t0, 56(%sp)
	lw	%t1, 44(%sp)
	lw	%t2, 56(%sp)
	sub	%t0, %t1, %t2
	sw	%t0, 60(%sp)
	li	%t0, 1
	sw	%t0, 64(%sp)
	lw	%t1, 64(%sp)
	lw	%t2, 68(%sp)
	slt	%t0, %t1, %t2
	sb	%t0, 72(%sp)
	lb	%t1, 72(%sp)
	beqz	%t1, .Lif.end_0
	j	.Lif.then_0

.Lif.then_0:
	la	%t0, .str.0
	sw	%t0, 73(%sp)
	lw	%t1, 73(%sp)
	mv	%a0, %t1
	call	print
	mv	%t0, %ra
	sb	%t0, 77(%sp)
	j	.Lif.end_0

.Lif.end_0:
	lw	%t1, 44(%sp)
	lw	%t0, 0(%t1)
	sw	%t0, 44(%sp)
	lw	%t1, 56(%sp)
	lw	%t0, 0(%t1)
	sw	%t0, 56(%sp)
	lw	%t1, 44(%sp)
	lw	%t2, 56(%sp)
	sub	%t0, %t1, %t2
	sw	%t0, 77(%sp)
	la	%t0, @i
	sw	%t0, 81(%sp)
	lw	%t1, 85(%sp)
	sw	%t0, 0(%t1)
	sw	%t0, 81(%sp)
	la	%t0, @i
	sw	%t0, 89(%sp)
	j	.Lfor.cond_0

.Lfor.cond_0:
	lw	%t1, 44(%sp)
	lw	%t0, 0(%t1)
	sw	%t0, 44(%sp)
	lw	%t1, 56(%sp)
	lw	%t0, 0(%t1)
	sw	%t0, 56(%sp)
	lw	%t1, 44(%sp)
	lw	%t2, 56(%sp)
	add	%t0, %t1, %t2
	sw	%t0, 93(%sp)
	lw	%t1, 89(%sp)
	lw	%t0, 0(%t1)
	sw	%t0, 89(%sp)
	lw	%t1, 97(%sp)
	lw	%t2, 89(%sp)
	slt	%t0, %t1, %t2
	sw	%t0, 101(%sp)
	lw	%t1, 101(%sp)
	xori	%t0, %t1, 1
	sb	%t0, 105(%sp)
	lb	%t1, 105(%sp)
	beqz	%t1, .Lfor.end_0
	j	.Lfor.body_0

.Lfor.inc_0:
	lw	%t1, 89(%sp)
	lw	%t0, 0(%t1)
	sw	%t0, 89(%sp)
	li	%t0, 1
	sw	%t0, 106(%sp)
	lw	%t1, 89(%sp)
	lw	%t2, 106(%sp)
	add	%t0, %t1, %t2
	sw	%t0, 110(%sp)
	lw	%t1, 114(%sp)
	sw	%t0, 0(%t1)
	sw	%t0, 89(%sp)
	j	.Lfor.cond_0

.Lfor.body_0:
	lw	%t1, 89(%sp)
	lw	%t0, 0(%t1)
	sw	%t0, 89(%sp)
	li	%t0, 1
	sw	%t0, 118(%sp)
	lw	%t1, 89(%sp)
	lw	%t2, 118(%sp)
	slt	%t0, %t1, %t2
	sw	%t0, 122(%sp)
	lw	%t1, 122(%sp)
	xori	%t0, %t1, 1
	sb	%t0, 126(%sp)
	lb	%t1, 126(%sp)
	beqz	%t1, .Lshort.quick_0
	j	.Lshort.rhs_0

.Lshort.rhs_0:
	lw	%t1, 89(%sp)
	lw	%t0, 0(%t1)
	sw	%t0, 89(%sp)
	lw	%t1, 32(%sp)
	lw	%t0, 0(%t1)
	sw	%t0, 32(%sp)
	lw	%t1, 32(%sp)
	lw	%t2, 89(%sp)
	slt	%t0, %t1, %t2
	sw	%t0, 127(%sp)
	lw	%t1, 127(%sp)
	xori	%t0, %t1, 1
	sb	%t0, 131(%sp)
	lb	%t1, 131(%sp)
	mv	%t0, %t1
	sb	%t0, 132(%sp)
	lb	%t1, 132(%sp)
	sb	%t0, 0(%t1)
	sw	%t0, 4(%sp)
	j	.Lshort.end_0

.Lshort.quick_0:
	sb	%t0, 0(%zero)
	sw	%t0, 4(%sp)
	j	.Lshort.end_0

.Lshort.end_0:
	lw	%t1, 4(%sp)
	lb	%t0, 0(%t1)
	sw	%t0, 4(%sp)
	lw	%t1, 4(%sp)
	mv	%t0, %t1
	sb	%t0, 133(%sp)
	lb	%t1, 133(%sp)
	beqz	%t1, .Lif.end_1
	j	.Lif.then_1

.Lif.then_1:
	lw	%t1, 89(%sp)
	lw	%t0, 0(%t1)
	sw	%t0, 89(%sp)
	lw	%t1, 44(%sp)
	lw	%t0, 0(%t1)
	sw	%t0, 44(%sp)
	lw	%t1, 89(%sp)
	lw	%t2, 44(%sp)
	sub	%t0, %t1, %t2
	sw	%t0, 134(%sp)
	lw	%t1, 134(%sp)
	seqz	%t0, %t1, 0
	sb	%t0, 138(%sp)
	lb	%t1, 138(%sp)
	beqz	%t1, .Lif.else_2
	j	.Lif.then_2

.Lif.then_2:
	la	%t0, .str.1
	sw	%t0, 139(%sp)
	lw	%t1, 139(%sp)
	mv	%a0, %t1
	call	print
	mv	%t0, %ra
	sb	%t0, 143(%sp)
	lw	%t1, 89(%sp)
	lw	%t0, 0(%t1)
	sw	%t0, 89(%sp)
	lw	%t1, 89(%sp)
	mv	%a0, %t1
	call	toString
	mv	%t0, %ra
	sw	%t0, 143(%sp)
	lw	%t1, 143(%sp)
	mv	%a0, %t1
	call	print
	mv	%t0, %ra
	sb	%t0, 147(%sp)
	la	%t0, .str.2
	sw	%t0, 147(%sp)
	lw	%t1, 147(%sp)
	mv	%a0, %t1
	call	print
	mv	%t0, %ra
	sb	%t0, 151(%sp)
	j	.Lif.end_2

.Lif.else_2:
	lw	%t1, 89(%sp)
	lw	%t0, 0(%t1)
	sw	%t0, 89(%sp)
	lw	%t1, 89(%sp)
	mv	%a0, %t1
	call	printInt
	mv	%t0, %ra
	sb	%t0, 151(%sp)
	la	%t0, .str.3
	sw	%t0, 151(%sp)
	lw	%t1, 151(%sp)
	mv	%a0, %t1
	call	print
	mv	%t0, %ra
	sb	%t0, 155(%sp)
	j	.Lif.end_2

.Lif.end_2:
	j	.Lif.end_1

.Lif.end_1:
	j	.Lfor.inc_0

.Lfor.end_0:
	lw	%t1, 44(%sp)
	lw	%t0, 0(%t1)
	sw	%t0, 44(%sp)
	lw	%t1, 56(%sp)
	lw	%t0, 0(%t1)
	sw	%t0, 56(%sp)
	lw	%t1, 44(%sp)
	lw	%t2, 56(%sp)
	add	%t0, %t1, %t2
	sw	%t0, 155(%sp)
	lw	%t1, 32(%sp)
	lw	%t0, 0(%t1)
	sw	%t0, 32(%sp)
	lw	%t1, 159(%sp)
	lw	%t2, 32(%sp)
	slt	%t0, %t1, %t2
	sb	%t0, 163(%sp)
	lb	%t1, 163(%sp)
	beqz	%t1, .Lif.end_3
	j	.Lif.then_3

.Lif.then_3:
	la	%t0, .str.4
	sw	%t0, 164(%sp)
	lw	%t1, 164(%sp)
	mv	%a0, %t1
	call	print
	mv	%t0, %ra
	sb	%t0, 168(%sp)
	j	.Lif.end_3

.Lif.end_3:
	sw	%t0, 0(%zero)
	sw	%t0, 8(%sp)
	j	.Lexit_main_0
	addi	%sp, %sp, 74
	ret

.Lexit_main_0:
	lw	%t1, 8(%sp)
	lw	%t0, 0(%t1)
	sw	%t0, 8(%sp)
	lw	%t1, 8(%sp)
	mv	%a0, %t1
	lw	%ra, 0(%sp)


.text
	.globl
__mx_global_var_init:
.Lenter___mx_global_var_init_0:
	addi	%sp, %sp, 0
	sw	%ra, 0(%sp)
	j	.Lexit___mx_global_var_init_0
	addi	%sp, %sp, 0
	ret

.Lexit___mx_global_var_init_0:
	lw	%ra, 0(%sp)



