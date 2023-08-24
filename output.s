	.section .data
@A:
	.word 	1
@B:
	.word 	1
@C:
	.word 	1
	.section .rodata
.str.0:
.asciz	" "
	.text
	.globl	main
main:
.Lenter_main_0:
	li	t1, -9252
	add	sp, sp, t1
	sw	ra, 0(sp)
	li	t0, 4
	sw	t0, 12(sp)
	lw	t2, 12(sp)
	add	t0, sp, t2
	sw	t0, 16(sp)
	li	t0, 8
	sw	t0, 20(sp)
	lw	t2, 20(sp)
	add	t0, sp, t2
	sw	t0, 24(sp)
	li	t0, 0
	lw	t1, 24(sp)
	sw	t0, 0(t1)
	call	__mx_global_var_init
	j	.Lwhile.cond_0

.Lwhile.cond_0:
	li	t0, 1
	li	t0, 29
	sll	t0, t0, t0
	sw	t0, 28(sp)
	la	t2, @C
	sw	t2, 32(sp)
	lw	t1, 32(sp)
	lw	t0, 0(t1)
	sw	t0, 36(sp)
	lw	t1, 36(sp)
	lw	t2, 28(sp)
	slt	t0, t1, t2
	sb	t0, 40(sp)
	lb	t1, 40(sp)
	beqz	t1, .Lshort.quick_0
	j	.Lshort.rhs_0

.Lshort.rhs_0:
	li	t0, 1
	li	t0, 29
	sll	t0, t0, t0
	sw	t0, 41(sp)
	li	t0, 0
	lw	t2, 41(sp)
	sub	t0, t0, t2
	sw	t0, 45(sp)
	la	t2, @C
	sw	t2, 49(sp)
	lw	t1, 49(sp)
	lw	t0, 0(t1)
	sw	t0, 53(sp)
	lw	t1, 45(sp)
	lw	t2, 53(sp)
	slt	t0, t1, t2
	sb	t0, 57(sp)
	lb	t1, 57(sp)
	mv	t0, t1
	sb	t0, 58(sp)
	lw	t1, 16(sp)
	lb	t0, 58(sp)
	sb	t0, 0(t1)
	j	.Lshort.end_0

.Lshort.quick_0:
	li	t0, 0
	lw	t1, 16(sp)
	sb	t0, 0(t1)
	j	.Lshort.end_0

.Lshort.end_0:
	lw	t1, 16(sp)
	lb	t0, 0(t1)
	sb	t0, 59(sp)
	lb	t1, 59(sp)
	mv	t0, t1
	sb	t0, 60(sp)
	lb	t1, 60(sp)
	beqz	t1, .Lwhile.end_0
	j	.Lwhile.body_0

.Lwhile.body_0:
	la	t2, @C
	sw	t2, 61(sp)
	lw	t1, 61(sp)
	lw	t0, 0(t1)
	sw	t0, 65(sp)
	la	t2, @A
	sw	t2, 69(sp)
	lw	t1, 69(sp)
	lw	t0, 0(t1)
	sw	t0, 73(sp)
	lw	t1, 65(sp)
	lw	t2, 73(sp)
	sub	t0, t1, t2
	sw	t0, 77(sp)
	la	t2, @B
	sw	t2, 81(sp)
	lw	t1, 81(sp)
	lw	t0, 0(t1)
	sw	t0, 85(sp)
	lw	t1, 77(sp)
	lw	t2, 85(sp)
	add	t0, t1, t2
	sw	t0, 89(sp)
	la	t2, @A
	sw	t2, 93(sp)
	lw	t1, 93(sp)
	lw	t0, 0(t1)
	sw	t0, 97(sp)
	la	t2, @B
	sw	t2, 101(sp)
	lw	t1, 101(sp)
	lw	t0, 0(t1)
	sw	t0, 105(sp)
	lw	t1, 97(sp)
	lw	t2, 105(sp)
	add	t0, t1, t2
	sw	t0, 109(sp)
	lw	t1, 89(sp)
	lw	t2, 109(sp)
	sub	t0, t1, t2
	sw	t0, 113(sp)
	la	t2, @C
	sw	t2, 117(sp)
	lw	t1, 117(sp)
	lw	t0, 0(t1)
	sw	t0, 121(sp)
	la	t2, @A
	sw	t2, 125(sp)
	lw	t1, 125(sp)
	lw	t0, 0(t1)
	sw	t0, 129(sp)
	lw	t1, 121(sp)
	lw	t2, 129(sp)
	sub	t0, t1, t2
	sw	t0, 133(sp)
	la	t2, @B
	sw	t2, 137(sp)
	lw	t1, 137(sp)
	lw	t0, 0(t1)
	sw	t0, 141(sp)
	lw	t1, 133(sp)
	lw	t2, 141(sp)
	add	t0, t1, t2
	sw	t0, 145(sp)
	la	t2, @A
	sw	t2, 149(sp)
	lw	t1, 149(sp)
	lw	t0, 0(t1)
	sw	t0, 153(sp)
	la	t2, @B
	sw	t2, 157(sp)
	lw	t1, 157(sp)
	lw	t0, 0(t1)
	sw	t0, 161(sp)
	lw	t1, 153(sp)
	lw	t2, 161(sp)
	add	t0, t1, t2
	sw	t0, 165(sp)
	lw	t1, 145(sp)
	lw	t2, 165(sp)
	sub	t0, t1, t2
	sw	t0, 169(sp)
	lw	t1, 113(sp)
	lw	t2, 169(sp)
	add	t0, t1, t2
	sw	t0, 173(sp)
	la	t2, @C
	sw	t2, 177(sp)
	lw	t1, 177(sp)
	lw	t0, 0(t1)
	sw	t0, 181(sp)
	la	t2, @A
	sw	t2, 185(sp)
	lw	t1, 185(sp)
	lw	t0, 0(t1)
	sw	t0, 189(sp)
	lw	t1, 181(sp)
	lw	t2, 189(sp)
	sub	t0, t1, t2
	sw	t0, 193(sp)
	la	t2, @B
	sw	t2, 197(sp)
	lw	t1, 197(sp)
	lw	t0, 0(t1)
	sw	t0, 201(sp)
	lw	t1, 193(sp)
	lw	t2, 201(sp)
	add	t0, t1, t2
	sw	t0, 205(sp)
	la	t2, @A
	sw	t2, 209(sp)
	lw	t1, 209(sp)
	lw	t0, 0(t1)
	sw	t0, 213(sp)
	la	t2, @B
	sw	t2, 217(sp)
	lw	t1, 217(sp)
	lw	t0, 0(t1)
	sw	t0, 221(sp)
	lw	t1, 213(sp)
	lw	t2, 221(sp)
	add	t0, t1, t2
	sw	t0, 225(sp)
	lw	t1, 205(sp)
	lw	t2, 225(sp)
	sub	t0, t1, t2
	sw	t0, 229(sp)
	la	t2, @C
	sw	t2, 233(sp)
	lw	t1, 233(sp)
	lw	t0, 0(t1)
	sw	t0, 237(sp)
	la	t2, @A
	sw	t2, 241(sp)
	lw	t1, 241(sp)
	lw	t0, 0(t1)
	sw	t0, 245(sp)
	lw	t1, 237(sp)
	lw	t2, 245(sp)
	sub	t0, t1, t2
	sw	t0, 249(sp)
	la	t2, @B
	sw	t2, 253(sp)
	lw	t1, 253(sp)
	lw	t0, 0(t1)
	sw	t0, 257(sp)
	lw	t1, 249(sp)
	lw	t2, 257(sp)
	add	t0, t1, t2
	sw	t0, 261(sp)
	lw	t1, 229(sp)
	lw	t2, 261(sp)
	add	t0, t1, t2
	sw	t0, 265(sp)
	lw	t1, 173(sp)
	lw	t2, 265(sp)
	add	t0, t1, t2
	sw	t0, 269(sp)
	la	t2, @A
	sw	t2, 273(sp)
	lw	t1, 273(sp)
	lw	t0, 0(t1)
	sw	t0, 277(sp)
	la	t2, @B
	sw	t2, 281(sp)
	lw	t1, 281(sp)
	lw	t0, 0(t1)
	sw	t0, 285(sp)
	lw	t1, 277(sp)
	lw	t2, 285(sp)
	add	t0, t1, t2
	sw	t0, 289(sp)
	la	t2, @C
	sw	t2, 293(sp)
	lw	t1, 293(sp)
	lw	t0, 0(t1)
	sw	t0, 297(sp)
	la	t2, @A
	sw	t2, 301(sp)
	lw	t1, 301(sp)
	lw	t0, 0(t1)
	sw	t0, 305(sp)
	lw	t1, 297(sp)
	lw	t2, 305(sp)
	sub	t0, t1, t2
	sw	t0, 309(sp)
	la	t2, @B
	sw	t2, 313(sp)
	lw	t1, 313(sp)
	lw	t0, 0(t1)
	sw	t0, 317(sp)
	lw	t1, 309(sp)
	lw	t2, 317(sp)
	add	t0, t1, t2
	sw	t0, 321(sp)
	lw	t1, 289(sp)
	lw	t2, 321(sp)
	add	t0, t1, t2
	sw	t0, 325(sp)
	la	t2, @A
	sw	t2, 329(sp)
	lw	t1, 329(sp)
	lw	t0, 0(t1)
	sw	t0, 333(sp)
	la	t2, @B
	sw	t2, 337(sp)
	lw	t1, 337(sp)
	lw	t0, 0(t1)
	sw	t0, 341(sp)
	lw	t1, 333(sp)
	lw	t2, 341(sp)
	add	t0, t1, t2
	sw	t0, 345(sp)
	lw	t1, 325(sp)
	lw	t2, 345(sp)
	sub	t0, t1, t2
	sw	t0, 349(sp)
	la	t2, @C
	sw	t2, 353(sp)
	lw	t1, 353(sp)
	lw	t0, 0(t1)
	sw	t0, 357(sp)
	la	t2, @A
	sw	t2, 361(sp)
	lw	t1, 361(sp)
	lw	t0, 0(t1)
	sw	t0, 365(sp)
	lw	t1, 357(sp)
	lw	t2, 365(sp)
	sub	t0, t1, t2
	sw	t0, 369(sp)
	la	t2, @B
	sw	t2, 373(sp)
	lw	t1, 373(sp)
	lw	t0, 0(t1)
	sw	t0, 377(sp)
	lw	t1, 369(sp)
	lw	t2, 377(sp)
	add	t0, t1, t2
	sw	t0, 381(sp)
	la	t2, @A
	sw	t2, 385(sp)
	lw	t1, 385(sp)
	lw	t0, 0(t1)
	sw	t0, 389(sp)
	la	t2, @B
	sw	t2, 393(sp)
	lw	t1, 393(sp)
	lw	t0, 0(t1)
	sw	t0, 397(sp)
	lw	t1, 389(sp)
	lw	t2, 397(sp)
	add	t0, t1, t2
	sw	t0, 401(sp)
	lw	t1, 381(sp)
	lw	t2, 401(sp)
	sub	t0, t1, t2
	sw	t0, 405(sp)
	la	t2, @C
	sw	t2, 409(sp)
	lw	t1, 409(sp)
	lw	t0, 0(t1)
	sw	t0, 413(sp)
	la	t2, @A
	sw	t2, 417(sp)
	lw	t1, 417(sp)
	lw	t0, 0(t1)
	sw	t0, 421(sp)
	lw	t1, 413(sp)
	lw	t2, 421(sp)
	sub	t0, t1, t2
	sw	t0, 425(sp)
	la	t2, @B
	sw	t2, 429(sp)
	lw	t1, 429(sp)
	lw	t0, 0(t1)
	sw	t0, 433(sp)
	lw	t1, 425(sp)
	lw	t2, 433(sp)
	add	t0, t1, t2
	sw	t0, 437(sp)
	lw	t1, 405(sp)
	lw	t2, 437(sp)
	add	t0, t1, t2
	sw	t0, 441(sp)
	lw	t1, 349(sp)
	lw	t2, 441(sp)
	add	t0, t1, t2
	sw	t0, 445(sp)
	lw	t1, 269(sp)
	lw	t2, 445(sp)
	sub	t0, t1, t2
	sw	t0, 449(sp)
	la	t2, @A
	sw	t2, 453(sp)
	lw	t1, 453(sp)
	lw	t0, 0(t1)
	sw	t0, 457(sp)
	la	t2, @B
	sw	t2, 461(sp)
	lw	t1, 461(sp)
	lw	t0, 0(t1)
	sw	t0, 465(sp)
	lw	t1, 457(sp)
	lw	t2, 465(sp)
	add	t0, t1, t2
	sw	t0, 469(sp)
	la	t2, @C
	sw	t2, 473(sp)
	lw	t1, 473(sp)
	lw	t0, 0(t1)
	sw	t0, 477(sp)
	la	t2, @A
	sw	t2, 481(sp)
	lw	t1, 481(sp)
	lw	t0, 0(t1)
	sw	t0, 485(sp)
	lw	t1, 477(sp)
	lw	t2, 485(sp)
	sub	t0, t1, t2
	sw	t0, 489(sp)
	la	t2, @B
	sw	t2, 493(sp)
	lw	t1, 493(sp)
	lw	t0, 0(t1)
	sw	t0, 497(sp)
	lw	t1, 489(sp)
	lw	t2, 497(sp)
	add	t0, t1, t2
	sw	t0, 501(sp)
	lw	t1, 469(sp)
	lw	t2, 501(sp)
	add	t0, t1, t2
	sw	t0, 505(sp)
	la	t2, @A
	sw	t2, 509(sp)
	lw	t1, 509(sp)
	lw	t0, 0(t1)
	sw	t0, 513(sp)
	la	t2, @B
	sw	t2, 517(sp)
	lw	t1, 517(sp)
	lw	t0, 0(t1)
	sw	t0, 521(sp)
	lw	t1, 513(sp)
	lw	t2, 521(sp)
	add	t0, t1, t2
	sw	t0, 525(sp)
	la	t2, @C
	sw	t2, 529(sp)
	lw	t1, 529(sp)
	lw	t0, 0(t1)
	sw	t0, 533(sp)
	la	t2, @A
	sw	t2, 537(sp)
	lw	t1, 537(sp)
	lw	t0, 0(t1)
	sw	t0, 541(sp)
	lw	t1, 533(sp)
	lw	t2, 541(sp)
	sub	t0, t1, t2
	sw	t0, 545(sp)
	la	t2, @B
	sw	t2, 549(sp)
	lw	t1, 549(sp)
	lw	t0, 0(t1)
	sw	t0, 553(sp)
	lw	t1, 545(sp)
	lw	t2, 553(sp)
	add	t0, t1, t2
	sw	t0, 557(sp)
	lw	t1, 525(sp)
	lw	t2, 557(sp)
	add	t0, t1, t2
	sw	t0, 561(sp)
	lw	t1, 505(sp)
	lw	t2, 561(sp)
	sub	t0, t1, t2
	sw	t0, 565(sp)
	la	t2, @A
	sw	t2, 569(sp)
	lw	t1, 569(sp)
	lw	t0, 0(t1)
	sw	t0, 573(sp)
	la	t2, @B
	sw	t2, 577(sp)
	lw	t1, 577(sp)
	lw	t0, 0(t1)
	sw	t0, 581(sp)
	lw	t1, 573(sp)
	lw	t2, 581(sp)
	add	t0, t1, t2
	sw	t0, 585(sp)
	la	t2, @C
	sw	t2, 589(sp)
	lw	t1, 589(sp)
	lw	t0, 0(t1)
	sw	t0, 593(sp)
	la	t2, @A
	sw	t2, 597(sp)
	lw	t1, 597(sp)
	lw	t0, 0(t1)
	sw	t0, 601(sp)
	lw	t1, 593(sp)
	lw	t2, 601(sp)
	sub	t0, t1, t2
	sw	t0, 605(sp)
	la	t2, @B
	sw	t2, 609(sp)
	lw	t1, 609(sp)
	lw	t0, 0(t1)
	sw	t0, 613(sp)
	lw	t1, 605(sp)
	lw	t2, 613(sp)
	add	t0, t1, t2
	sw	t0, 617(sp)
	lw	t1, 585(sp)
	lw	t2, 617(sp)
	add	t0, t1, t2
	sw	t0, 621(sp)
	la	t2, @A
	sw	t2, 625(sp)
	lw	t1, 625(sp)
	lw	t0, 0(t1)
	sw	t0, 629(sp)
	la	t2, @B
	sw	t2, 633(sp)
	lw	t1, 633(sp)
	lw	t0, 0(t1)
	sw	t0, 637(sp)
	lw	t1, 629(sp)
	lw	t2, 637(sp)
	add	t0, t1, t2
	sw	t0, 641(sp)
	lw	t1, 621(sp)
	lw	t2, 641(sp)
	sub	t0, t1, t2
	sw	t0, 645(sp)
	lw	t1, 565(sp)
	lw	t2, 645(sp)
	sub	t0, t1, t2
	sw	t0, 649(sp)
	la	t2, @C
	sw	t2, 653(sp)
	lw	t1, 653(sp)
	lw	t0, 0(t1)
	sw	t0, 657(sp)
	la	t2, @A
	sw	t2, 661(sp)
	lw	t1, 661(sp)
	lw	t0, 0(t1)
	sw	t0, 665(sp)
	lw	t1, 657(sp)
	lw	t2, 665(sp)
	sub	t0, t1, t2
	sw	t0, 669(sp)
	la	t2, @B
	sw	t2, 673(sp)
	lw	t1, 673(sp)
	lw	t0, 0(t1)
	sw	t0, 677(sp)
	lw	t1, 669(sp)
	lw	t2, 677(sp)
	add	t0, t1, t2
	sw	t0, 681(sp)
	la	t2, @A
	sw	t2, 685(sp)
	lw	t1, 685(sp)
	lw	t0, 0(t1)
	sw	t0, 689(sp)
	la	t2, @B
	sw	t2, 693(sp)
	lw	t1, 693(sp)
	lw	t0, 0(t1)
	sw	t0, 697(sp)
	lw	t1, 689(sp)
	lw	t2, 697(sp)
	add	t0, t1, t2
	sw	t0, 701(sp)
	lw	t1, 681(sp)
	lw	t2, 701(sp)
	sub	t0, t1, t2
	sw	t0, 705(sp)
	la	t2, @C
	sw	t2, 709(sp)
	lw	t1, 709(sp)
	lw	t0, 0(t1)
	sw	t0, 713(sp)
	la	t2, @A
	sw	t2, 717(sp)
	lw	t1, 717(sp)
	lw	t0, 0(t1)
	sw	t0, 721(sp)
	lw	t1, 713(sp)
	lw	t2, 721(sp)
	sub	t0, t1, t2
	sw	t0, 725(sp)
	la	t2, @B
	sw	t2, 729(sp)
	lw	t1, 729(sp)
	lw	t0, 0(t1)
	sw	t0, 733(sp)
	lw	t1, 725(sp)
	lw	t2, 733(sp)
	add	t0, t1, t2
	sw	t0, 737(sp)
	lw	t1, 705(sp)
	lw	t2, 737(sp)
	add	t0, t1, t2
	sw	t0, 741(sp)
	la	t2, @A
	sw	t2, 745(sp)
	lw	t1, 745(sp)
	lw	t0, 0(t1)
	sw	t0, 749(sp)
	la	t2, @B
	sw	t2, 753(sp)
	lw	t1, 753(sp)
	lw	t0, 0(t1)
	sw	t0, 757(sp)
	lw	t1, 749(sp)
	lw	t2, 757(sp)
	add	t0, t1, t2
	sw	t0, 761(sp)
	la	t2, @C
	sw	t2, 765(sp)
	lw	t1, 765(sp)
	lw	t0, 0(t1)
	sw	t0, 769(sp)
	la	t2, @A
	sw	t2, 773(sp)
	lw	t1, 773(sp)
	lw	t0, 0(t1)
	sw	t0, 777(sp)
	lw	t1, 769(sp)
	lw	t2, 777(sp)
	sub	t0, t1, t2
	sw	t0, 781(sp)
	la	t2, @B
	sw	t2, 785(sp)
	lw	t1, 785(sp)
	lw	t0, 0(t1)
	sw	t0, 789(sp)
	lw	t1, 781(sp)
	lw	t2, 789(sp)
	add	t0, t1, t2
	sw	t0, 793(sp)
	lw	t1, 761(sp)
	lw	t2, 793(sp)
	add	t0, t1, t2
	sw	t0, 797(sp)
	la	t2, @A
	sw	t2, 801(sp)
	lw	t1, 801(sp)
	lw	t0, 0(t1)
	sw	t0, 805(sp)
	la	t2, @B
	sw	t2, 809(sp)
	lw	t1, 809(sp)
	lw	t0, 0(t1)
	sw	t0, 813(sp)
	lw	t1, 805(sp)
	lw	t2, 813(sp)
	add	t0, t1, t2
	sw	t0, 817(sp)
	lw	t1, 797(sp)
	lw	t2, 817(sp)
	sub	t0, t1, t2
	sw	t0, 821(sp)
	lw	t1, 741(sp)
	lw	t2, 821(sp)
	sub	t0, t1, t2
	sw	t0, 825(sp)
	lw	t1, 649(sp)
	lw	t2, 825(sp)
	add	t0, t1, t2
	sw	t0, 829(sp)
	lw	t1, 449(sp)
	lw	t2, 829(sp)
	sub	t0, t1, t2
	sw	t0, 833(sp)
	la	t2, @C
	sw	t2, 837(sp)
	lw	t1, 837(sp)
	lw	t0, 0(t1)
	sw	t0, 841(sp)
	la	t2, @A
	sw	t2, 845(sp)
	lw	t1, 845(sp)
	lw	t0, 0(t1)
	sw	t0, 849(sp)
	lw	t1, 841(sp)
	lw	t2, 849(sp)
	sub	t0, t1, t2
	sw	t0, 853(sp)
	la	t2, @B
	sw	t2, 857(sp)
	lw	t1, 857(sp)
	lw	t0, 0(t1)
	sw	t0, 861(sp)
	lw	t1, 853(sp)
	lw	t2, 861(sp)
	add	t0, t1, t2
	sw	t0, 865(sp)
	la	t2, @A
	sw	t2, 869(sp)
	lw	t1, 869(sp)
	lw	t0, 0(t1)
	sw	t0, 873(sp)
	la	t2, @B
	sw	t2, 877(sp)
	lw	t1, 877(sp)
	lw	t0, 0(t1)
	sw	t0, 881(sp)
	lw	t1, 873(sp)
	lw	t2, 881(sp)
	add	t0, t1, t2
	sw	t0, 885(sp)
	lw	t1, 865(sp)
	lw	t2, 885(sp)
	sub	t0, t1, t2
	sw	t0, 889(sp)
	la	t2, @C
	sw	t2, 893(sp)
	lw	t1, 893(sp)
	lw	t0, 0(t1)
	sw	t0, 897(sp)
	la	t2, @A
	sw	t2, 901(sp)
	lw	t1, 901(sp)
	lw	t0, 0(t1)
	sw	t0, 905(sp)
	lw	t1, 897(sp)
	lw	t2, 905(sp)
	sub	t0, t1, t2
	sw	t0, 909(sp)
	la	t2, @B
	sw	t2, 913(sp)
	lw	t1, 913(sp)
	lw	t0, 0(t1)
	sw	t0, 917(sp)
	lw	t1, 909(sp)
	lw	t2, 917(sp)
	add	t0, t1, t2
	sw	t0, 921(sp)
	la	t2, @A
	sw	t2, 925(sp)
	lw	t1, 925(sp)
	lw	t0, 0(t1)
	sw	t0, 929(sp)
	la	t2, @B
	sw	t2, 933(sp)
	lw	t1, 933(sp)
	lw	t0, 0(t1)
	sw	t0, 937(sp)
	lw	t1, 929(sp)
	lw	t2, 937(sp)
	add	t0, t1, t2
	sw	t0, 941(sp)
	lw	t1, 921(sp)
	lw	t2, 941(sp)
	sub	t0, t1, t2
	sw	t0, 945(sp)
	lw	t1, 889(sp)
	lw	t2, 945(sp)
	add	t0, t1, t2
	sw	t0, 949(sp)
	la	t2, @C
	sw	t2, 953(sp)
	lw	t1, 953(sp)
	lw	t0, 0(t1)
	sw	t0, 957(sp)
	la	t2, @A
	sw	t2, 961(sp)
	lw	t1, 961(sp)
	lw	t0, 0(t1)
	sw	t0, 965(sp)
	lw	t1, 957(sp)
	lw	t2, 965(sp)
	sub	t0, t1, t2
	sw	t0, 969(sp)
	la	t2, @B
	sw	t2, 973(sp)
	lw	t1, 973(sp)
	lw	t0, 0(t1)
	sw	t0, 977(sp)
	lw	t1, 969(sp)
	lw	t2, 977(sp)
	add	t0, t1, t2
	sw	t0, 981(sp)
	la	t2, @A
	sw	t2, 985(sp)
	lw	t1, 985(sp)
	lw	t0, 0(t1)
	sw	t0, 989(sp)
	la	t2, @B
	sw	t2, 993(sp)
	lw	t1, 993(sp)
	lw	t0, 0(t1)
	sw	t0, 997(sp)
	lw	t1, 989(sp)
	lw	t2, 997(sp)
	add	t0, t1, t2
	sw	t0, 1001(sp)
	lw	t1, 981(sp)
	lw	t2, 1001(sp)
	sub	t0, t1, t2
	sw	t0, 1005(sp)
	la	t2, @C
	sw	t2, 1009(sp)
	lw	t1, 1009(sp)
	lw	t0, 0(t1)
	sw	t0, 1013(sp)
	la	t2, @A
	sw	t2, 1017(sp)
	lw	t1, 1017(sp)
	lw	t0, 0(t1)
	sw	t0, 1021(sp)
	lw	t1, 1013(sp)
	lw	t2, 1021(sp)
	sub	t0, t1, t2
	sw	t0, 1025(sp)
	la	t2, @B
	sw	t2, 1029(sp)
	lw	t1, 1029(sp)
	lw	t0, 0(t1)
	sw	t0, 1033(sp)
	lw	t1, 1025(sp)
	lw	t2, 1033(sp)
	add	t0, t1, t2
	sw	t0, 1037(sp)
	lw	t1, 1005(sp)
	lw	t2, 1037(sp)
	add	t0, t1, t2
	sw	t0, 1041(sp)
	lw	t1, 949(sp)
	lw	t2, 1041(sp)
	add	t0, t1, t2
	sw	t0, 1045(sp)
	la	t2, @A
	sw	t2, 1049(sp)
	lw	t1, 1049(sp)
	lw	t0, 0(t1)
	sw	t0, 1053(sp)
	la	t2, @B
	sw	t2, 1057(sp)
	lw	t1, 1057(sp)
	lw	t0, 0(t1)
	sw	t0, 1061(sp)
	lw	t1, 1053(sp)
	lw	t2, 1061(sp)
	add	t0, t1, t2
	sw	t0, 1065(sp)
	la	t2, @C
	sw	t2, 1069(sp)
	lw	t1, 1069(sp)
	lw	t0, 0(t1)
	sw	t0, 1073(sp)
	la	t2, @A
	sw	t2, 1077(sp)
	lw	t1, 1077(sp)
	lw	t0, 0(t1)
	sw	t0, 1081(sp)
	lw	t1, 1073(sp)
	lw	t2, 1081(sp)
	sub	t0, t1, t2
	sw	t0, 1085(sp)
	la	t2, @B
	sw	t2, 1089(sp)
	lw	t1, 1089(sp)
	lw	t0, 0(t1)
	sw	t0, 1093(sp)
	lw	t1, 1085(sp)
	lw	t2, 1093(sp)
	add	t0, t1, t2
	sw	t0, 1097(sp)
	lw	t1, 1065(sp)
	lw	t2, 1097(sp)
	add	t0, t1, t2
	sw	t0, 1101(sp)
	la	t2, @A
	sw	t2, 1105(sp)
	lw	t1, 1105(sp)
	lw	t0, 0(t1)
	sw	t0, 1109(sp)
	la	t2, @B
	sw	t2, 1113(sp)
	lw	t1, 1113(sp)
	lw	t0, 0(t1)
	sw	t0, 1117(sp)
	lw	t1, 1109(sp)
	lw	t2, 1117(sp)
	add	t0, t1, t2
	sw	t0, 1121(sp)
	lw	t1, 1101(sp)
	lw	t2, 1121(sp)
	sub	t0, t1, t2
	sw	t0, 1125(sp)
	la	t2, @C
	sw	t2, 1129(sp)
	lw	t1, 1129(sp)
	lw	t0, 0(t1)
	sw	t0, 1133(sp)
	la	t2, @A
	sw	t2, 1137(sp)
	lw	t1, 1137(sp)
	lw	t0, 0(t1)
	sw	t0, 1141(sp)
	lw	t1, 1133(sp)
	lw	t2, 1141(sp)
	sub	t0, t1, t2
	sw	t0, 1145(sp)
	la	t2, @B
	sw	t2, 1149(sp)
	lw	t1, 1149(sp)
	lw	t0, 0(t1)
	sw	t0, 1153(sp)
	lw	t1, 1145(sp)
	lw	t2, 1153(sp)
	add	t0, t1, t2
	sw	t0, 1157(sp)
	la	t2, @A
	sw	t2, 1161(sp)
	lw	t1, 1161(sp)
	lw	t0, 0(t1)
	sw	t0, 1165(sp)
	la	t2, @B
	sw	t2, 1169(sp)
	lw	t1, 1169(sp)
	lw	t0, 0(t1)
	sw	t0, 1173(sp)
	lw	t1, 1165(sp)
	lw	t2, 1173(sp)
	add	t0, t1, t2
	sw	t0, 1177(sp)
	lw	t1, 1157(sp)
	lw	t2, 1177(sp)
	sub	t0, t1, t2
	sw	t0, 1181(sp)
	la	t2, @C
	sw	t2, 1185(sp)
	lw	t1, 1185(sp)
	lw	t0, 0(t1)
	sw	t0, 1189(sp)
	la	t2, @A
	sw	t2, 1193(sp)
	lw	t1, 1193(sp)
	lw	t0, 0(t1)
	sw	t0, 1197(sp)
	lw	t1, 1189(sp)
	lw	t2, 1197(sp)
	sub	t0, t1, t2
	sw	t0, 1201(sp)
	la	t2, @B
	sw	t2, 1205(sp)
	lw	t1, 1205(sp)
	lw	t0, 0(t1)
	sw	t0, 1209(sp)
	lw	t1, 1201(sp)
	lw	t2, 1209(sp)
	add	t0, t1, t2
	sw	t0, 1213(sp)
	lw	t1, 1181(sp)
	lw	t2, 1213(sp)
	add	t0, t1, t2
	sw	t0, 1217(sp)
	lw	t1, 1125(sp)
	lw	t2, 1217(sp)
	add	t0, t1, t2
	sw	t0, 1221(sp)
	lw	t1, 1045(sp)
	lw	t2, 1221(sp)
	sub	t0, t1, t2
	sw	t0, 1225(sp)
	la	t2, @A
	sw	t2, 1229(sp)
	lw	t1, 1229(sp)
	lw	t0, 0(t1)
	sw	t0, 1233(sp)
	la	t2, @B
	sw	t2, 1237(sp)
	lw	t1, 1237(sp)
	lw	t0, 0(t1)
	sw	t0, 1241(sp)
	lw	t1, 1233(sp)
	lw	t2, 1241(sp)
	add	t0, t1, t2
	sw	t0, 1245(sp)
	la	t2, @C
	sw	t2, 1249(sp)
	lw	t1, 1249(sp)
	lw	t0, 0(t1)
	sw	t0, 1253(sp)
	la	t2, @A
	sw	t2, 1257(sp)
	lw	t1, 1257(sp)
	lw	t0, 0(t1)
	sw	t0, 1261(sp)
	lw	t1, 1253(sp)
	lw	t2, 1261(sp)
	sub	t0, t1, t2
	sw	t0, 1265(sp)
	la	t2, @B
	sw	t2, 1269(sp)
	lw	t1, 1269(sp)
	lw	t0, 0(t1)
	sw	t0, 1273(sp)
	lw	t1, 1265(sp)
	lw	t2, 1273(sp)
	add	t0, t1, t2
	sw	t0, 1277(sp)
	lw	t1, 1245(sp)
	lw	t2, 1277(sp)
	add	t0, t1, t2
	sw	t0, 1281(sp)
	la	t2, @A
	sw	t2, 1285(sp)
	lw	t1, 1285(sp)
	lw	t0, 0(t1)
	sw	t0, 1289(sp)
	la	t2, @B
	sw	t2, 1293(sp)
	lw	t1, 1293(sp)
	lw	t0, 0(t1)
	sw	t0, 1297(sp)
	lw	t1, 1289(sp)
	lw	t2, 1297(sp)
	add	t0, t1, t2
	sw	t0, 1301(sp)
	lw	t1, 1281(sp)
	lw	t2, 1301(sp)
	sub	t0, t1, t2
	sw	t0, 1305(sp)
	la	t2, @C
	sw	t2, 1309(sp)
	lw	t1, 1309(sp)
	lw	t0, 0(t1)
	sw	t0, 1313(sp)
	la	t2, @A
	sw	t2, 1317(sp)
	lw	t1, 1317(sp)
	lw	t0, 0(t1)
	sw	t0, 1321(sp)
	lw	t1, 1313(sp)
	lw	t2, 1321(sp)
	sub	t0, t1, t2
	sw	t0, 1325(sp)
	la	t2, @B
	sw	t2, 1329(sp)
	lw	t1, 1329(sp)
	lw	t0, 0(t1)
	sw	t0, 1333(sp)
	lw	t1, 1325(sp)
	lw	t2, 1333(sp)
	add	t0, t1, t2
	sw	t0, 1337(sp)
	la	t2, @A
	sw	t2, 1341(sp)
	lw	t1, 1341(sp)
	lw	t0, 0(t1)
	sw	t0, 1345(sp)
	la	t2, @B
	sw	t2, 1349(sp)
	lw	t1, 1349(sp)
	lw	t0, 0(t1)
	sw	t0, 1353(sp)
	lw	t1, 1345(sp)
	lw	t2, 1353(sp)
	add	t0, t1, t2
	sw	t0, 1357(sp)
	lw	t1, 1337(sp)
	lw	t2, 1357(sp)
	sub	t0, t1, t2
	sw	t0, 1361(sp)
	la	t2, @C
	sw	t2, 1365(sp)
	lw	t1, 1365(sp)
	lw	t0, 0(t1)
	sw	t0, 1369(sp)
	la	t2, @A
	sw	t2, 1373(sp)
	lw	t1, 1373(sp)
	lw	t0, 0(t1)
	sw	t0, 1377(sp)
	lw	t1, 1369(sp)
	lw	t2, 1377(sp)
	sub	t0, t1, t2
	sw	t0, 1381(sp)
	la	t2, @B
	sw	t2, 1385(sp)
	lw	t1, 1385(sp)
	lw	t0, 0(t1)
	sw	t0, 1389(sp)
	lw	t1, 1381(sp)
	lw	t2, 1389(sp)
	add	t0, t1, t2
	sw	t0, 1393(sp)
	lw	t1, 1361(sp)
	lw	t2, 1393(sp)
	add	t0, t1, t2
	sw	t0, 1397(sp)
	lw	t1, 1305(sp)
	lw	t2, 1397(sp)
	add	t0, t1, t2
	sw	t0, 1401(sp)
	la	t2, @A
	sw	t2, 1405(sp)
	lw	t1, 1405(sp)
	lw	t0, 0(t1)
	sw	t0, 1409(sp)
	la	t2, @B
	sw	t2, 1413(sp)
	lw	t1, 1413(sp)
	lw	t0, 0(t1)
	sw	t0, 1417(sp)
	lw	t1, 1409(sp)
	lw	t2, 1417(sp)
	add	t0, t1, t2
	sw	t0, 1421(sp)
	la	t2, @C
	sw	t2, 1425(sp)
	lw	t1, 1425(sp)
	lw	t0, 0(t1)
	sw	t0, 1429(sp)
	la	t2, @A
	sw	t2, 1433(sp)
	lw	t1, 1433(sp)
	lw	t0, 0(t1)
	sw	t0, 1437(sp)
	lw	t1, 1429(sp)
	lw	t2, 1437(sp)
	sub	t0, t1, t2
	sw	t0, 1441(sp)
	la	t2, @B
	sw	t2, 1445(sp)
	lw	t1, 1445(sp)
	lw	t0, 0(t1)
	sw	t0, 1449(sp)
	lw	t1, 1441(sp)
	lw	t2, 1449(sp)
	add	t0, t1, t2
	sw	t0, 1453(sp)
	lw	t1, 1421(sp)
	lw	t2, 1453(sp)
	add	t0, t1, t2
	sw	t0, 1457(sp)
	la	t2, @A
	sw	t2, 1461(sp)
	lw	t1, 1461(sp)
	lw	t0, 0(t1)
	sw	t0, 1465(sp)
	la	t2, @B
	sw	t2, 1469(sp)
	lw	t1, 1469(sp)
	lw	t0, 0(t1)
	sw	t0, 1473(sp)
	lw	t1, 1465(sp)
	lw	t2, 1473(sp)
	add	t0, t1, t2
	sw	t0, 1477(sp)
	lw	t1, 1457(sp)
	lw	t2, 1477(sp)
	sub	t0, t1, t2
	sw	t0, 1481(sp)
	la	t2, @C
	sw	t2, 1485(sp)
	lw	t1, 1485(sp)
	lw	t0, 0(t1)
	sw	t0, 1489(sp)
	la	t2, @A
	sw	t2, 1493(sp)
	lw	t1, 1493(sp)
	lw	t0, 0(t1)
	sw	t0, 1497(sp)
	lw	t1, 1489(sp)
	lw	t2, 1497(sp)
	sub	t0, t1, t2
	sw	t0, 1501(sp)
	la	t2, @B
	sw	t2, 1505(sp)
	lw	t1, 1505(sp)
	lw	t0, 0(t1)
	sw	t0, 1509(sp)
	lw	t1, 1501(sp)
	lw	t2, 1509(sp)
	add	t0, t1, t2
	sw	t0, 1513(sp)
	la	t2, @A
	sw	t2, 1517(sp)
	lw	t1, 1517(sp)
	lw	t0, 0(t1)
	sw	t0, 1521(sp)
	la	t2, @B
	sw	t2, 1525(sp)
	lw	t1, 1525(sp)
	lw	t0, 0(t1)
	sw	t0, 1529(sp)
	lw	t1, 1521(sp)
	lw	t2, 1529(sp)
	add	t0, t1, t2
	sw	t0, 1533(sp)
	lw	t1, 1513(sp)
	lw	t2, 1533(sp)
	sub	t0, t1, t2
	sw	t0, 1537(sp)
	la	t2, @C
	sw	t2, 1541(sp)
	lw	t1, 1541(sp)
	lw	t0, 0(t1)
	sw	t0, 1545(sp)
	la	t2, @A
	sw	t2, 1549(sp)
	lw	t1, 1549(sp)
	lw	t0, 0(t1)
	sw	t0, 1553(sp)
	lw	t1, 1545(sp)
	lw	t2, 1553(sp)
	sub	t0, t1, t2
	sw	t0, 1557(sp)
	la	t2, @B
	sw	t2, 1561(sp)
	lw	t1, 1561(sp)
	lw	t0, 0(t1)
	sw	t0, 1565(sp)
	lw	t1, 1557(sp)
	lw	t2, 1565(sp)
	add	t0, t1, t2
	sw	t0, 1569(sp)
	lw	t1, 1537(sp)
	lw	t2, 1569(sp)
	add	t0, t1, t2
	sw	t0, 1573(sp)
	lw	t1, 1481(sp)
	lw	t2, 1573(sp)
	add	t0, t1, t2
	sw	t0, 1577(sp)
	lw	t1, 1401(sp)
	lw	t2, 1577(sp)
	sub	t0, t1, t2
	sw	t0, 1581(sp)
	lw	t1, 1225(sp)
	lw	t2, 1581(sp)
	sub	t0, t1, t2
	sw	t0, 1585(sp)
	lw	t1, 833(sp)
	lw	t2, 1585(sp)
	add	t0, t1, t2
	sw	t0, 1589(sp)
	la	t2, @A
	sw	t2, 1593(sp)
	lw	t1, 1593(sp)
	lw	t0, 0(t1)
	sw	t0, 1597(sp)
	la	t2, @B
	sw	t2, 1601(sp)
	lw	t1, 1601(sp)
	lw	t0, 0(t1)
	sw	t0, 1605(sp)
	lw	t1, 1597(sp)
	lw	t2, 1605(sp)
	add	t0, t1, t2
	sw	t0, 1609(sp)
	la	t2, @C
	sw	t2, 1613(sp)
	lw	t1, 1613(sp)
	lw	t0, 0(t1)
	sw	t0, 1617(sp)
	la	t2, @A
	sw	t2, 1621(sp)
	lw	t1, 1621(sp)
	lw	t0, 0(t1)
	sw	t0, 1625(sp)
	lw	t1, 1617(sp)
	lw	t2, 1625(sp)
	sub	t0, t1, t2
	sw	t0, 1629(sp)
	la	t2, @B
	sw	t2, 1633(sp)
	lw	t1, 1633(sp)
	lw	t0, 0(t1)
	sw	t0, 1637(sp)
	lw	t1, 1629(sp)
	lw	t2, 1637(sp)
	add	t0, t1, t2
	sw	t0, 1641(sp)
	lw	t1, 1609(sp)
	lw	t2, 1641(sp)
	add	t0, t1, t2
	sw	t0, 1645(sp)
	la	t2, @A
	sw	t2, 1649(sp)
	lw	t1, 1649(sp)
	lw	t0, 0(t1)
	sw	t0, 1653(sp)
	la	t2, @B
	sw	t2, 1657(sp)
	lw	t1, 1657(sp)
	lw	t0, 0(t1)
	sw	t0, 1661(sp)
	lw	t1, 1653(sp)
	lw	t2, 1661(sp)
	add	t0, t1, t2
	sw	t0, 1665(sp)
	la	t2, @C
	sw	t2, 1669(sp)
	lw	t1, 1669(sp)
	lw	t0, 0(t1)
	sw	t0, 1673(sp)
	la	t2, @A
	sw	t2, 1677(sp)
	lw	t1, 1677(sp)
	lw	t0, 0(t1)
	sw	t0, 1681(sp)
	lw	t1, 1673(sp)
	lw	t2, 1681(sp)
	sub	t0, t1, t2
	sw	t0, 1685(sp)
	la	t2, @B
	sw	t2, 1689(sp)
	lw	t1, 1689(sp)
	lw	t0, 0(t1)
	sw	t0, 1693(sp)
	lw	t1, 1685(sp)
	lw	t2, 1693(sp)
	add	t0, t1, t2
	sw	t0, 1697(sp)
	lw	t1, 1665(sp)
	lw	t2, 1697(sp)
	add	t0, t1, t2
	sw	t0, 1701(sp)
	lw	t1, 1645(sp)
	lw	t2, 1701(sp)
	sub	t0, t1, t2
	sw	t0, 1705(sp)
	la	t2, @A
	sw	t2, 1709(sp)
	lw	t1, 1709(sp)
	lw	t0, 0(t1)
	sw	t0, 1713(sp)
	la	t2, @B
	sw	t2, 1717(sp)
	lw	t1, 1717(sp)
	lw	t0, 0(t1)
	sw	t0, 1721(sp)
	lw	t1, 1713(sp)
	lw	t2, 1721(sp)
	add	t0, t1, t2
	sw	t0, 1725(sp)
	la	t2, @C
	sw	t2, 1729(sp)
	lw	t1, 1729(sp)
	lw	t0, 0(t1)
	sw	t0, 1733(sp)
	la	t2, @A
	sw	t2, 1737(sp)
	lw	t1, 1737(sp)
	lw	t0, 0(t1)
	sw	t0, 1741(sp)
	lw	t1, 1733(sp)
	lw	t2, 1741(sp)
	sub	t0, t1, t2
	sw	t0, 1745(sp)
	la	t2, @B
	sw	t2, 1749(sp)
	lw	t1, 1749(sp)
	lw	t0, 0(t1)
	sw	t0, 1753(sp)
	lw	t1, 1745(sp)
	lw	t2, 1753(sp)
	add	t0, t1, t2
	sw	t0, 1757(sp)
	lw	t1, 1725(sp)
	lw	t2, 1757(sp)
	add	t0, t1, t2
	sw	t0, 1761(sp)
	la	t2, @A
	sw	t2, 1765(sp)
	lw	t1, 1765(sp)
	lw	t0, 0(t1)
	sw	t0, 1769(sp)
	la	t2, @B
	sw	t2, 1773(sp)
	lw	t1, 1773(sp)
	lw	t0, 0(t1)
	sw	t0, 1777(sp)
	lw	t1, 1769(sp)
	lw	t2, 1777(sp)
	add	t0, t1, t2
	sw	t0, 1781(sp)
	lw	t1, 1761(sp)
	lw	t2, 1781(sp)
	sub	t0, t1, t2
	sw	t0, 1785(sp)
	lw	t1, 1705(sp)
	lw	t2, 1785(sp)
	sub	t0, t1, t2
	sw	t0, 1789(sp)
	la	t2, @C
	sw	t2, 1793(sp)
	lw	t1, 1793(sp)
	lw	t0, 0(t1)
	sw	t0, 1797(sp)
	la	t2, @A
	sw	t2, 1801(sp)
	lw	t1, 1801(sp)
	lw	t0, 0(t1)
	sw	t0, 1805(sp)
	lw	t1, 1797(sp)
	lw	t2, 1805(sp)
	sub	t0, t1, t2
	sw	t0, 1809(sp)
	la	t2, @B
	sw	t2, 1813(sp)
	lw	t1, 1813(sp)
	lw	t0, 0(t1)
	sw	t0, 1817(sp)
	lw	t1, 1809(sp)
	lw	t2, 1817(sp)
	add	t0, t1, t2
	sw	t0, 1821(sp)
	la	t2, @A
	sw	t2, 1825(sp)
	lw	t1, 1825(sp)
	lw	t0, 0(t1)
	sw	t0, 1829(sp)
	la	t2, @B
	sw	t2, 1833(sp)
	lw	t1, 1833(sp)
	lw	t0, 0(t1)
	sw	t0, 1837(sp)
	lw	t1, 1829(sp)
	lw	t2, 1837(sp)
	add	t0, t1, t2
	sw	t0, 1841(sp)
	lw	t1, 1821(sp)
	lw	t2, 1841(sp)
	sub	t0, t1, t2
	sw	t0, 1845(sp)
	la	t2, @C
	sw	t2, 1849(sp)
	lw	t1, 1849(sp)
	lw	t0, 0(t1)
	sw	t0, 1853(sp)
	la	t2, @A
	sw	t2, 1857(sp)
	lw	t1, 1857(sp)
	lw	t0, 0(t1)
	sw	t0, 1861(sp)
	lw	t1, 1853(sp)
	lw	t2, 1861(sp)
	sub	t0, t1, t2
	sw	t0, 1865(sp)
	la	t2, @B
	sw	t2, 1869(sp)
	lw	t1, 1869(sp)
	lw	t0, 0(t1)
	sw	t0, 1873(sp)
	lw	t1, 1865(sp)
	lw	t2, 1873(sp)
	add	t0, t1, t2
	sw	t0, 1877(sp)
	lw	t1, 1845(sp)
	lw	t2, 1877(sp)
	add	t0, t1, t2
	sw	t0, 1881(sp)
	la	t2, @A
	sw	t2, 1885(sp)
	lw	t1, 1885(sp)
	lw	t0, 0(t1)
	sw	t0, 1889(sp)
	la	t2, @B
	sw	t2, 1893(sp)
	lw	t1, 1893(sp)
	lw	t0, 0(t1)
	sw	t0, 1897(sp)
	lw	t1, 1889(sp)
	lw	t2, 1897(sp)
	add	t0, t1, t2
	sw	t0, 1901(sp)
	la	t2, @C
	sw	t2, 1905(sp)
	lw	t1, 1905(sp)
	lw	t0, 0(t1)
	sw	t0, 1909(sp)
	la	t2, @A
	sw	t2, 1913(sp)
	lw	t1, 1913(sp)
	lw	t0, 0(t1)
	sw	t0, 1917(sp)
	lw	t1, 1909(sp)
	lw	t2, 1917(sp)
	sub	t0, t1, t2
	sw	t0, 1921(sp)
	la	t2, @B
	sw	t2, 1925(sp)
	lw	t1, 1925(sp)
	lw	t0, 0(t1)
	sw	t0, 1929(sp)
	lw	t1, 1921(sp)
	lw	t2, 1929(sp)
	add	t0, t1, t2
	sw	t0, 1933(sp)
	lw	t1, 1901(sp)
	lw	t2, 1933(sp)
	add	t0, t1, t2
	sw	t0, 1937(sp)
	la	t2, @A
	sw	t2, 1941(sp)
	lw	t1, 1941(sp)
	lw	t0, 0(t1)
	sw	t0, 1945(sp)
	la	t2, @B
	sw	t2, 1949(sp)
	lw	t1, 1949(sp)
	lw	t0, 0(t1)
	sw	t0, 1953(sp)
	lw	t1, 1945(sp)
	lw	t2, 1953(sp)
	add	t0, t1, t2
	sw	t0, 1957(sp)
	lw	t1, 1937(sp)
	lw	t2, 1957(sp)
	sub	t0, t1, t2
	sw	t0, 1961(sp)
	lw	t1, 1881(sp)
	lw	t2, 1961(sp)
	sub	t0, t1, t2
	sw	t0, 1965(sp)
	lw	t1, 1789(sp)
	lw	t2, 1965(sp)
	add	t0, t1, t2
	sw	t0, 1969(sp)
	la	t2, @C
	sw	t2, 1973(sp)
	lw	t1, 1973(sp)
	lw	t0, 0(t1)
	sw	t0, 1977(sp)
	la	t2, @A
	sw	t2, 1981(sp)
	lw	t1, 1981(sp)
	lw	t0, 0(t1)
	sw	t0, 1985(sp)
	lw	t1, 1977(sp)
	lw	t2, 1985(sp)
	sub	t0, t1, t2
	sw	t0, 1989(sp)
	la	t2, @B
	sw	t2, 1993(sp)
	lw	t1, 1993(sp)
	lw	t0, 0(t1)
	sw	t0, 1997(sp)
	lw	t1, 1989(sp)
	lw	t2, 1997(sp)
	add	t0, t1, t2
	sw	t0, 2001(sp)
	la	t2, @A
	sw	t2, 2005(sp)
	lw	t1, 2005(sp)
	lw	t0, 0(t1)
	sw	t0, 2009(sp)
	la	t2, @B
	sw	t2, 2013(sp)
	lw	t1, 2013(sp)
	lw	t0, 0(t1)
	sw	t0, 2017(sp)
	lw	t1, 2009(sp)
	lw	t2, 2017(sp)
	add	t0, t1, t2
	sw	t0, 2021(sp)
	lw	t1, 2001(sp)
	lw	t2, 2021(sp)
	sub	t0, t1, t2
	sw	t0, 2025(sp)
	la	t2, @C
	sw	t2, 2029(sp)
	lw	t1, 2029(sp)
	lw	t0, 0(t1)
	sw	t0, 2033(sp)
	la	t2, @A
	sw	t2, 2037(sp)
	lw	t1, 2037(sp)
	lw	t0, 0(t1)
	sw	t0, 2041(sp)
	lw	t1, 2033(sp)
	lw	t2, 2041(sp)
	sub	t0, t1, t2
	sw	t0, 2045(sp)
	la	t2, @B
	li	t0, 2049
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2049
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2053
	add	t0, sp, t0
	sw	t0, 0(t0)
	lw	t1, 2045(sp)
	li	t0, 2053
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2057
	add	t0, sp, t0
	sw	t0, 0(t0)
	lw	t1, 2025(sp)
	li	t0, 2057
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2061
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 2065
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2065
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2069
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 2073
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2073
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2077
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2069
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2077
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2081
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 2085
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2085
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2089
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 2093
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2093
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2097
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2089
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2097
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 2101
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 2105
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2105
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2109
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2101
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2109
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2113
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2081
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2113
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2117
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 2121
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2121
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2125
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 2129
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2129
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2133
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2125
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2133
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2137
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2117
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2137
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 2141
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2061
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2141
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 2145
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 2149
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2149
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2153
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 2157
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2157
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2161
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2153
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2161
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 2165
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 2169
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2169
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2173
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2165
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2173
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2177
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 2181
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2181
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2185
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 2189
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2189
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2193
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2185
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2193
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2197
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2177
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2197
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 2201
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 2205
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2205
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2209
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 2213
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2213
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2217
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2209
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2217
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 2221
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 2225
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2225
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2229
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2221
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2229
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2233
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2201
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2233
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2237
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 2241
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2241
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2245
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 2249
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2249
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2253
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2245
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2253
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2257
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 2261
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2261
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2265
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 2269
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2269
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2273
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2265
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2273
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 2277
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 2281
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2281
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2285
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2277
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2285
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2289
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2257
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2289
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2293
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 2297
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2297
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2301
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 2305
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2305
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2309
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2301
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2309
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2313
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2293
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2313
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 2317
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2237
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2317
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 2321
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2145
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2321
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2325
	add	t0, sp, t0
	sw	t0, 0(t0)
	lw	t1, 1969(sp)
	li	t0, 2325
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2329
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 2333
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2333
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2337
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 2341
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2341
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2345
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2337
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2345
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 2349
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 2353
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2353
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2357
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2349
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2357
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2361
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 2365
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2365
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2369
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 2373
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2373
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2377
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2369
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2377
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2381
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2361
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2381
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 2385
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 2389
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2389
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2393
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 2397
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2397
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2401
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2393
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2401
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 2405
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 2409
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2409
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2413
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2405
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2413
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2417
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 2421
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2421
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2425
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 2429
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2429
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2433
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2425
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2433
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2437
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2417
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2437
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 2441
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2385
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2441
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2445
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 2449
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2449
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2453
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 2457
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2457
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2461
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2453
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2461
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 2465
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 2469
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2469
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2473
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2465
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2473
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2477
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 2481
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2481
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2485
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 2489
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2489
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2493
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2485
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2493
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2497
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2477
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2497
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 2501
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 2505
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2505
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2509
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 2513
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2513
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2517
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2509
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2517
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 2521
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 2525
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2525
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2529
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2521
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2529
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2533
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2501
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2533
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2537
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2445
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2537
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2541
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 2545
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2545
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2549
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 2553
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2553
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2557
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2549
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2557
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2561
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 2565
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2565
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2569
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 2573
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2573
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2577
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2569
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2577
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 2581
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 2585
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2585
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2589
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2581
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2589
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2593
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2561
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2593
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2597
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 2601
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2601
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2605
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 2609
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2609
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2613
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2605
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2613
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2617
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2597
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2617
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 2621
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 2625
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2625
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2629
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 2633
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2633
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2637
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2629
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2637
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 2641
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 2645
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2645
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2649
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2641
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2649
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2653
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 2657
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2657
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2661
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 2665
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2665
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2669
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2661
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2669
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2673
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2653
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2673
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 2677
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 2681
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2681
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2685
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 2689
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2689
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2693
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2685
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2693
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 2697
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 2701
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2701
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2705
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2697
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2705
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2709
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2677
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2709
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2713
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2621
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2713
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2717
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2541
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2717
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 2721
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 2725
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2725
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2729
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 2733
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2733
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2737
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2729
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2737
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2741
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 2745
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2745
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2749
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 2753
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2753
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2757
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2749
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2757
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 2761
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 2765
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2765
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2769
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2761
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2769
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2773
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2741
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2773
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2777
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 2781
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2781
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2785
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 2789
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2789
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2793
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2785
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2793
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2797
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2777
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2797
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 2801
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 2805
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2805
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2809
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 2813
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2813
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2817
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2809
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2817
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 2821
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 2825
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2825
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2829
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2821
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2829
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2833
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 2837
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2837
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2841
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 2845
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2845
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2849
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2841
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2849
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2853
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2833
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2853
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 2857
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 2861
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2861
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2865
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 2869
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2869
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2873
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2865
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2873
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 2877
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 2881
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2881
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2885
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2877
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2885
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2889
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2857
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2889
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2893
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2801
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2893
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2897
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 2901
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2901
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2905
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 2909
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2909
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2913
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2905
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2913
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2917
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 2921
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2921
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2925
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 2929
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2929
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2933
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2925
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2933
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 2937
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 2941
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2941
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2945
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2937
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2945
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2949
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2917
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2949
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2953
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 2957
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2957
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2961
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 2965
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2965
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2969
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2961
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2969
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 2973
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2953
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2973
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 2977
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 2981
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2981
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2985
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 2989
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 2989
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 2993
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2985
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 2993
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 2997
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 3001
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3001
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3005
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2997
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3005
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3009
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 3013
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3013
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3017
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 3021
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3021
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3025
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3017
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3025
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3029
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3009
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3029
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 3033
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 3037
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3037
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3041
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 3045
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3045
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3049
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3041
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3049
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 3053
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 3057
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3057
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3061
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3053
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3061
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3065
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3033
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3065
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3069
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2977
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3069
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3073
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2897
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3073
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 3077
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2721
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3077
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 3081
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 2329
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3081
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3085
	add	t0, sp, t0
	sw	t0, 0(t0)
	lw	t1, 1589(sp)
	li	t0, 3085
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 3089
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 3093
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3093
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3089
	add	t0, sp, t0
	lw	t0, 0(t0)
	sw	t0, 0(t1)
	la	t2, @C
	li	t0, 3097
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3097
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3101
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 3105
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3105
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3109
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3101
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3109
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 3113
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 3117
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3117
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3121
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3113
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3121
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3125
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 3129
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3129
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3133
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 3137
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3137
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3141
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3133
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3141
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3145
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3125
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3145
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 3149
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 3153
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3153
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3157
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 3161
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3161
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3165
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3157
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3165
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 3169
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 3173
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3173
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3177
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3169
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3177
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3181
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 3185
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3185
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3189
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 3193
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3193
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3197
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3189
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3197
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3201
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3181
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3201
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 3205
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3149
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3205
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3209
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 3213
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3213
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3217
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 3221
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3221
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3225
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3217
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3225
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 3229
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 3233
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3233
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3237
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3229
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3237
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3241
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 3245
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3245
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3249
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 3253
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3253
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3257
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3249
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3257
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3261
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3241
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3261
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 3265
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 3269
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3269
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3273
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 3277
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3277
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3281
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3273
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3281
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 3285
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 3289
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3289
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3293
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3285
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3293
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3297
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3265
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3297
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3301
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3209
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3301
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3305
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 3309
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3309
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3313
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 3317
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3317
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3321
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3313
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3321
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3325
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 3329
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3329
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3333
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 3337
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3337
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3341
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3333
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3341
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 3345
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 3349
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3349
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3353
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3345
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3353
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3357
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3325
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3357
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3361
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 3365
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3365
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3369
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 3373
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3373
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3377
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3369
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3377
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3381
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3361
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3381
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 3385
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 3389
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3389
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3393
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 3397
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3397
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3401
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3393
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3401
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 3405
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 3409
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3409
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3413
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3405
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3413
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3417
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 3421
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3421
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3425
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 3429
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3429
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3433
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3425
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3433
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3437
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3417
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3437
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 3441
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 3445
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3445
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3449
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 3453
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3453
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3457
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3449
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3457
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 3461
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 3465
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3465
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3469
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3461
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3469
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3473
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3441
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3473
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3477
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3385
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3477
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3481
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3305
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3481
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 3485
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 3489
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3489
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3493
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 3497
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3497
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3501
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3493
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3501
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3505
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 3509
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3509
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3513
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 3517
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3517
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3521
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3513
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3521
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 3525
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 3529
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3529
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3533
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3525
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3533
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3537
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3505
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3537
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3541
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 3545
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3545
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3549
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 3553
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3553
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3557
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3549
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3557
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3561
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 3565
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3565
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3569
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 3573
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3573
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3577
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3569
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3577
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 3581
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 3585
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3585
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3589
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3581
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3589
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3593
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3561
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3593
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3597
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3541
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3597
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 3601
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 3605
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3605
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3609
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 3613
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3613
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3617
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3609
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3617
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3621
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 3625
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3625
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3629
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 3633
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3633
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3637
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3629
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3637
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 3641
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 3645
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3645
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3649
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3641
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3649
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3653
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3621
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3653
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3657
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 3661
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3661
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3665
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 3669
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3669
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3673
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3665
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3673
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3677
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3657
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3677
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 3681
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3601
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3681
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 3685
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 3689
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3689
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3693
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 3697
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3697
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3701
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3693
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3701
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 3705
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 3709
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3709
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3713
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3705
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3713
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3717
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 3721
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3721
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3725
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 3729
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3729
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3733
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3725
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3733
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3737
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3717
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3737
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 3741
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 3745
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3745
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3749
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 3753
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3753
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3757
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3749
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3757
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 3761
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 3765
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3765
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3769
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3761
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3769
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3773
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3741
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3773
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3777
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 3781
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3781
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3785
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 3789
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3789
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3793
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3785
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3793
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3797
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 3801
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3801
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3805
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 3809
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3809
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3813
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3805
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3813
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 3817
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 3821
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3821
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3825
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3817
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3825
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3829
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3797
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3829
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3833
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 3837
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3837
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3841
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 3845
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3845
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3849
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3841
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3849
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3853
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3833
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3853
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 3857
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3777
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3857
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 3861
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3685
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3861
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3865
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3485
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3865
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 3869
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 3873
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3873
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3877
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 3881
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3881
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3885
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3877
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3885
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 3889
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 3893
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3893
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3897
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3889
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3897
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3901
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 3905
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3905
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3909
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 3913
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3913
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3917
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3909
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3917
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3921
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3901
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3921
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 3925
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 3929
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3929
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3933
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 3937
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3937
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3941
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3933
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3941
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 3945
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 3949
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3949
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3953
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3945
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3953
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3957
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 3961
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3961
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3965
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 3969
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3969
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3973
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3965
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3973
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3977
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3957
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3977
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 3981
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3925
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 3981
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 3985
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 3989
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3989
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 3993
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 3997
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 3997
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4001
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3993
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4001
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 4005
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 4009
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4009
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4013
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4005
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4013
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4017
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 4021
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4021
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4025
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 4029
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4029
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4033
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4025
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4033
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4037
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4017
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4037
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 4041
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 4045
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4045
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4049
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 4053
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4053
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4057
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4049
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4057
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 4061
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 4065
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4065
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4069
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4061
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4069
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4073
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4041
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4073
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4077
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3985
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4077
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4081
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 4085
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4085
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4089
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 4093
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4093
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4097
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4089
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4097
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4101
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 4105
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4105
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4109
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 4113
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4113
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4117
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4109
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4117
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 4121
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 4125
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4125
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4129
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4121
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4129
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4133
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4101
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4133
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4137
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 4141
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4141
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4145
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 4149
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4149
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4153
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4145
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4153
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4157
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4137
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4157
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 4161
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 4165
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4165
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4169
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 4173
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4173
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4177
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4169
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4177
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 4181
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 4185
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4185
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4189
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4181
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4189
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4193
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 4197
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4197
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4201
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 4205
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4205
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4209
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4201
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4209
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4213
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4193
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4213
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 4217
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 4221
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4221
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4225
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 4229
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4229
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4233
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4225
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4233
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 4237
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 4241
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4241
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4245
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4237
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4245
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4249
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4217
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4249
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4253
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4161
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4253
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4257
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4081
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4257
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 4261
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 4265
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4265
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4269
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 4273
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4273
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4277
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4269
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4277
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4281
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 4285
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4285
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4289
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 4293
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4293
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4297
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4289
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4297
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 4301
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 4305
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4305
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4309
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4301
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4309
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4313
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4281
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4313
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4317
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 4321
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4321
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4325
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 4329
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4329
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4333
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4325
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4333
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4337
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4317
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4337
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 4341
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 4345
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4345
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4349
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 4353
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4353
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4357
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4349
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4357
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 4361
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 4365
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4365
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4369
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4361
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4369
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4373
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 4377
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4377
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4381
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 4385
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4385
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4389
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4381
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4389
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4393
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4373
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4393
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 4397
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 4401
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4401
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4405
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 4409
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4409
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4413
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4405
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4413
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 4417
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 4421
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4421
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4425
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4417
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4425
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4429
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4397
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4429
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4433
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4341
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4433
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4437
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 4441
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4441
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4445
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 4449
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4449
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4453
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4445
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4453
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4457
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 4461
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4461
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4465
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 4469
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4469
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4473
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4465
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4473
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 4477
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 4481
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4481
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4485
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4477
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4485
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4489
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4457
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4489
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4493
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 4497
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4497
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4501
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 4505
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4505
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4509
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4501
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4509
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4513
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4493
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4513
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 4517
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 4521
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4521
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4525
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 4529
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4529
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4533
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4525
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4533
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 4537
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 4541
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4541
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4545
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4537
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4545
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4549
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 4553
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4553
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4557
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 4561
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4561
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4565
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4557
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4565
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4569
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4549
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4569
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 4573
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 4577
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4577
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4581
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 4585
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4585
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4589
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4581
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4589
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 4593
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 4597
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4597
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4601
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4593
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4601
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4605
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4573
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4605
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4609
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4517
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4609
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4613
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4437
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4613
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 4617
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4261
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4617
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 4621
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 3869
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4621
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4625
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 4629
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4629
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4633
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 4637
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4637
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4641
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4633
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4641
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4645
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 4649
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4649
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4653
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 4657
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4657
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4661
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4653
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4661
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 4665
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 4669
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4669
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4673
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4665
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4673
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4677
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4645
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4677
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4681
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 4685
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4685
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4689
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 4693
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4693
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4697
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4689
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4697
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4701
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 4705
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4705
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4709
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 4713
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4713
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4717
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4709
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4717
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 4721
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 4725
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4725
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4729
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4721
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4729
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4733
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4701
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4733
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4737
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4681
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4737
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 4741
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 4745
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4745
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4749
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 4753
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4753
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4757
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4749
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4757
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4761
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 4765
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4765
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4769
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 4773
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4773
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4777
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4769
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4777
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 4781
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 4785
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4785
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4789
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4781
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4789
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4793
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4761
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4793
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4797
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 4801
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4801
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4805
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 4809
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4809
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4813
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4805
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4813
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4817
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4797
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4817
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 4821
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4741
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4821
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 4825
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 4829
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4829
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4833
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 4837
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4837
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4841
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4833
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4841
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 4845
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 4849
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4849
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4853
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4845
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4853
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4857
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 4861
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4861
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4865
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 4869
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4869
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4873
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4865
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4873
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4877
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4857
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4877
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 4881
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 4885
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4885
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4889
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 4893
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4893
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4897
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4889
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4897
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 4901
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 4905
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4905
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4909
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4901
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4909
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4913
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4881
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4913
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4917
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 4921
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4921
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4925
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 4929
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4929
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4933
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4925
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4933
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4937
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 4941
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4941
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4945
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 4949
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4949
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4953
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4945
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4953
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 4957
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 4961
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4961
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4965
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4957
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4965
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4969
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4937
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4969
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4973
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 4977
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4977
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4981
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 4985
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 4985
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 4989
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4981
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4989
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 4993
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4973
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4993
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 4997
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4917
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 4997
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 5001
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4825
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5001
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5005
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 5009
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5009
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5013
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 5017
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5017
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5021
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5013
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5021
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 5025
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 5029
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5029
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5033
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5025
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5033
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5037
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 5041
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5041
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5045
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 5049
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5049
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5053
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5045
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5053
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5057
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5037
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5057
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 5061
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 5065
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5065
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5069
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 5073
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5073
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5077
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5069
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5077
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 5081
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 5085
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5085
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5089
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5081
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5089
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5093
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5061
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5093
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5097
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 5101
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5101
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5105
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 5109
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5109
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5113
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5105
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5113
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5117
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 5121
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5121
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5125
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 5129
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5129
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5133
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5125
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5133
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 5137
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 5141
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5141
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5145
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5137
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5145
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5149
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5117
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5149
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5153
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 5157
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5157
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5161
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 5165
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5165
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5169
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5161
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5169
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5173
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5153
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5173
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 5177
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5097
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5177
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 5181
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 5185
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5185
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5189
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 5193
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5193
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5197
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5189
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5197
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 5201
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 5205
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5205
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5209
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5201
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5209
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5213
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 5217
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5217
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5221
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 5225
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5225
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5229
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5221
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5229
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5233
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5213
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5233
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 5237
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 5241
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5241
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5245
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 5249
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5249
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5253
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5245
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5253
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 5257
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 5261
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5261
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5265
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5257
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5265
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5269
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5237
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5269
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5273
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 5277
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5277
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5281
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 5285
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5285
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5289
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5281
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5289
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5293
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 5297
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5297
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5301
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 5305
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5305
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5309
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5301
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5309
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 5313
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 5317
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5317
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5321
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5313
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5321
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5325
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5293
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5325
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5329
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 5333
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5333
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5337
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 5341
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5341
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5345
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5337
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5345
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5349
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5329
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5349
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 5353
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5273
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5353
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 5357
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5181
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5357
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5361
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5005
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5361
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5365
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 5369
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5369
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5373
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 5377
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5377
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5381
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5373
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5381
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 5385
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 5389
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5389
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5393
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5385
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5393
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5397
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 5401
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5401
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5405
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 5409
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5409
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5413
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5405
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5413
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5417
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5397
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5417
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 5421
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 5425
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5425
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5429
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 5433
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5433
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5437
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5429
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5437
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 5441
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 5445
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5445
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5449
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5441
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5449
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5453
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 5457
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5457
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5461
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 5465
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5465
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5469
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5461
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5469
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5473
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5453
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5473
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 5477
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5421
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5477
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5481
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 5485
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5485
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5489
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 5493
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5493
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5497
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5489
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5497
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 5501
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 5505
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5505
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5509
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5501
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5509
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5513
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 5517
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5517
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5521
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 5525
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5525
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5529
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5521
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5529
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5533
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5513
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5533
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 5537
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 5541
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5541
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5545
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 5549
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5549
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5553
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5545
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5553
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 5557
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 5561
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5561
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5565
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5557
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5565
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5569
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5537
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5569
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5573
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5481
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5573
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5577
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 5581
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5581
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5585
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 5589
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5589
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5593
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5585
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5593
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5597
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 5601
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5601
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5605
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 5609
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5609
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5613
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5605
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5613
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 5617
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 5621
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5621
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5625
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5617
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5625
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5629
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5597
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5629
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5633
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 5637
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5637
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5641
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 5645
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5645
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5649
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5641
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5649
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5653
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5633
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5653
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 5657
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 5661
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5661
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5665
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 5669
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5669
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5673
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5665
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5673
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 5677
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 5681
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5681
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5685
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5677
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5685
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5689
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 5693
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5693
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5697
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 5701
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5701
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5705
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5697
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5705
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5709
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5689
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5709
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 5713
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 5717
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5717
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5721
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 5725
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5725
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5729
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5721
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5729
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 5733
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 5737
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5737
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5741
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5733
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5741
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5745
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5713
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5745
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5749
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5657
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5749
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5753
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5577
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5753
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 5757
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 5761
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5761
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5765
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 5769
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5769
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5773
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5765
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5773
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5777
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 5781
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5781
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5785
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 5789
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5789
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5793
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5785
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5793
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 5797
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 5801
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5801
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5805
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5797
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5805
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5809
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5777
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5809
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5813
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 5817
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5817
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5821
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 5825
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5825
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5829
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5821
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5829
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5833
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5813
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5833
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 5837
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 5841
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5841
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5845
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 5849
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5849
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5853
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5845
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5853
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 5857
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 5861
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5861
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5865
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5857
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5865
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5869
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 5873
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5873
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5877
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 5881
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5881
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5885
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5877
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5885
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5889
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5869
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5889
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 5893
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 5897
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5897
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5901
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 5905
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5905
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5909
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5901
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5909
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 5913
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 5917
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5917
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5921
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5913
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5921
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5925
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5893
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5925
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5929
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5837
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5929
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5933
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 5937
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5937
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5941
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 5945
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5945
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5949
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5941
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5949
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5953
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 5957
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5957
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5961
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 5965
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5965
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5969
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5961
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5969
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 5973
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 5977
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5977
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5981
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5973
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5981
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5985
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5953
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 5985
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 5989
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 5993
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 5993
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 5997
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 6001
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6001
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6005
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5997
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6005
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6009
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5989
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6009
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 6013
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 6017
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6017
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6021
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 6025
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6025
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6029
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6021
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6029
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 6033
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 6037
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6037
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6041
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6033
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6041
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6045
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 6049
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6049
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6053
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 6057
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6057
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6061
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6053
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6061
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6065
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6045
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6065
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 6069
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 6073
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6073
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6077
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 6081
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6081
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6085
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6077
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6085
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 6089
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 6093
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6093
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6097
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6089
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6097
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6101
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6069
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6101
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6105
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6013
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6105
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6109
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5933
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6109
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 6113
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5757
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6113
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 6117
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 5365
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6117
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6121
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 4625
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6121
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 6125
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 6129
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6129
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6125
	add	t0, sp, t0
	lw	t0, 0(t0)
	sw	t0, 0(t1)
	la	t2, @C
	li	t0, 6133
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6133
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6137
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 6141
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6141
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6145
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6137
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6145
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 6149
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 6153
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6153
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6157
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6149
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6157
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6161
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 6165
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6165
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6169
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 6173
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6173
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6177
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6169
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6177
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6181
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6161
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6181
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 6185
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 6189
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6189
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6193
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 6197
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6197
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6201
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6193
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6201
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 6205
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 6209
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6209
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6213
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6205
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6213
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6217
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 6221
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6221
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6225
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 6229
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6229
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6233
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6225
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6233
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6237
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6217
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6237
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 6241
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6185
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6241
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6245
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 6249
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6249
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6253
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 6257
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6257
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6261
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6253
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6261
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 6265
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 6269
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6269
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6273
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6265
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6273
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6277
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 6281
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6281
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6285
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 6289
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6289
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6293
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6285
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6293
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6297
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6277
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6297
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 6301
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 6305
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6305
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6309
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 6313
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6313
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6317
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6309
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6317
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 6321
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 6325
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6325
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6329
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6321
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6329
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6333
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6301
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6333
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6337
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6245
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6337
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6341
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 6345
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6345
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6349
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 6353
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6353
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6357
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6349
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6357
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6361
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 6365
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6365
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6369
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 6373
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6373
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6377
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6369
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6377
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 6381
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 6385
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6385
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6389
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6381
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6389
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6393
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6361
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6393
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6397
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 6401
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6401
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6405
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 6409
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6409
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6413
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6405
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6413
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6417
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6397
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6417
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 6421
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 6425
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6425
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6429
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 6433
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6433
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6437
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6429
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6437
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 6441
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 6445
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6445
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6449
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6441
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6449
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6453
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 6457
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6457
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6461
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 6465
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6465
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6469
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6461
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6469
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6473
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6453
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6473
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 6477
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 6481
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6481
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6485
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 6489
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6489
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6493
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6485
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6493
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 6497
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 6501
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6501
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6505
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6497
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6505
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6509
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6477
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6509
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6513
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6421
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6513
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6517
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6341
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6517
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 6521
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 6525
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6525
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6529
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 6533
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6533
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6537
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6529
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6537
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6541
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 6545
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6545
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6549
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 6553
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6553
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6557
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6549
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6557
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 6561
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 6565
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6565
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6569
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6561
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6569
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6573
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6541
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6573
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6577
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 6581
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6581
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6585
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 6589
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6589
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6593
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6585
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6593
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6597
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 6601
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6601
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6605
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 6609
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6609
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6613
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6605
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6613
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 6617
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 6621
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6621
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6625
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6617
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6625
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6629
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6597
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6629
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6633
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6577
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6633
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 6637
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 6641
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6641
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6645
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 6649
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6649
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6653
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6645
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6653
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6657
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 6661
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6661
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6665
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 6669
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6669
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6673
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6665
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6673
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 6677
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 6681
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6681
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6685
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6677
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6685
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6689
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6657
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6689
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6693
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 6697
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6697
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6701
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 6705
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6705
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6709
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6701
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6709
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6713
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6693
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6713
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 6717
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6637
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6717
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 6721
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 6725
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6725
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6729
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 6733
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6733
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6737
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6729
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6737
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 6741
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 6745
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6745
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6749
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6741
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6749
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6753
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 6757
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6757
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6761
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 6765
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6765
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6769
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6761
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6769
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6773
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6753
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6773
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 6777
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 6781
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6781
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6785
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 6789
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6789
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6793
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6785
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6793
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 6797
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 6801
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6801
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6805
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6797
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6805
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6809
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6777
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6809
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6813
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 6817
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6817
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6821
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 6825
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6825
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6829
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6821
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6829
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6833
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 6837
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6837
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6841
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 6845
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6845
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6849
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6841
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6849
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 6853
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 6857
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6857
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6861
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6853
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6861
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6865
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6833
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6865
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6869
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 6873
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6873
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6877
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 6881
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6881
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6885
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6877
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6885
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6889
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6869
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6889
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 6893
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6813
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6893
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 6897
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6721
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6897
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6901
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6521
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6901
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 6905
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 6909
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6909
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6913
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 6917
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6917
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6921
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6913
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6921
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 6925
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 6929
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6929
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6933
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6925
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6933
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6937
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 6941
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6941
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6945
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 6949
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6949
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6953
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6945
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6953
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6957
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6937
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6957
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 6961
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 6965
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6965
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6969
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 6973
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6973
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6977
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6969
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6977
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 6981
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 6985
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6985
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 6989
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6981
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 6989
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 6993
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 6997
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 6997
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7001
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 7005
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7005
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7009
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7001
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7009
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7013
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6993
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7013
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 7017
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6961
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7017
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7021
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 7025
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7025
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7029
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 7033
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7033
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7037
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7029
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7037
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 7041
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 7045
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7045
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7049
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7041
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7049
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7053
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 7057
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7057
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7061
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 7065
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7065
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7069
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7061
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7069
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7073
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7053
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7073
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 7077
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 7081
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7081
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7085
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 7089
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7089
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7093
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7085
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7093
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 7097
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 7101
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7101
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7105
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7097
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7105
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7109
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7077
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7109
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7113
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7021
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7113
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7117
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 7121
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7121
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7125
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 7129
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7129
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7133
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7125
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7133
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7137
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 7141
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7141
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7145
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 7149
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7149
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7153
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7145
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7153
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 7157
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 7161
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7161
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7165
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7157
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7165
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7169
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7137
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7169
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7173
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 7177
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7177
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7181
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 7185
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7185
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7189
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7181
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7189
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7193
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7173
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7193
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 7197
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 7201
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7201
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7205
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 7209
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7209
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7213
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7205
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7213
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 7217
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 7221
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7221
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7225
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7217
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7225
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7229
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 7233
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7233
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7237
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 7241
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7241
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7245
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7237
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7245
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7249
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7229
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7249
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 7253
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 7257
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7257
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7261
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 7265
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7265
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7269
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7261
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7269
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 7273
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 7277
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7277
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7281
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7273
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7281
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7285
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7253
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7285
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7289
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7197
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7289
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7293
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7117
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7293
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 7297
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 7301
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7301
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7305
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 7309
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7309
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7313
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7305
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7313
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7317
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 7321
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7321
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7325
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 7329
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7329
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7333
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7325
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7333
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 7337
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 7341
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7341
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7345
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7337
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7345
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7349
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7317
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7349
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7353
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 7357
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7357
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7361
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 7365
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7365
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7369
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7361
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7369
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7373
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7353
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7373
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 7377
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 7381
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7381
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7385
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 7389
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7389
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7393
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7385
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7393
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 7397
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 7401
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7401
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7405
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7397
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7405
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7409
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 7413
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7413
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7417
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 7421
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7421
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7425
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7417
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7425
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7429
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7409
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7429
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 7433
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 7437
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7437
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7441
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 7445
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7445
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7449
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7441
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7449
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 7453
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 7457
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7457
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7461
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7453
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7461
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7465
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7433
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7465
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7469
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7377
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7469
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7473
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 7477
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7477
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7481
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 7485
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7485
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7489
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7481
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7489
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7493
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 7497
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7497
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7501
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 7505
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7505
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7509
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7501
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7509
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 7513
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 7517
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7517
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7521
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7513
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7521
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7525
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7493
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7525
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7529
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 7533
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7533
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7537
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 7541
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7541
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7545
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7537
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7545
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7549
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7529
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7549
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 7553
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 7557
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7557
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7561
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 7565
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7565
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7569
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7561
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7569
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 7573
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 7577
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7577
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7581
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7573
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7581
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7585
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 7589
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7589
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7593
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 7597
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7597
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7601
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7593
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7601
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7605
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7585
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7605
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 7609
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 7613
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7613
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7617
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 7621
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7621
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7625
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7617
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7625
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 7629
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 7633
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7633
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7637
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7629
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7637
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7641
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7609
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7641
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7645
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7553
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7645
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7649
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7473
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7649
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 7653
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7297
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7653
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 7657
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 6905
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7657
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7661
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 7665
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7665
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7669
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 7673
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7673
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7677
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7669
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7677
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7681
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 7685
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7685
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7689
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 7693
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7693
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7697
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7689
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7697
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 7701
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 7705
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7705
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7709
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7701
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7709
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7713
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7681
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7713
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7717
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 7721
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7721
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7725
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 7729
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7729
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7733
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7725
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7733
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7737
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 7741
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7741
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7745
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 7749
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7749
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7753
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7745
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7753
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 7757
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 7761
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7761
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7765
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7757
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7765
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7769
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7737
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7769
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7773
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7717
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7773
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 7777
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 7781
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7781
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7785
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 7789
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7789
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7793
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7785
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7793
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7797
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 7801
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7801
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7805
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 7809
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7809
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7813
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7805
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7813
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 7817
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 7821
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7821
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7825
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7817
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7825
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7829
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7797
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7829
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7833
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 7837
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7837
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7841
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 7845
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7845
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7849
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7841
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7849
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7853
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7833
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7853
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 7857
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7777
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7857
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 7861
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 7865
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7865
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7869
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 7873
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7873
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7877
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7869
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7877
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 7881
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 7885
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7885
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7889
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7881
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7889
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7893
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 7897
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7897
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7901
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 7905
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7905
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7909
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7901
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7909
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7913
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7893
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7913
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 7917
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 7921
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7921
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7925
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 7929
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7929
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7933
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7925
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7933
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 7937
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 7941
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7941
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7945
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7937
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7945
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7949
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7917
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7949
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7953
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 7957
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7957
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7961
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 7965
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7965
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7969
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7961
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7969
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 7973
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 7977
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7977
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7981
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 7985
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7985
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 7989
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7981
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 7989
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 7993
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 7997
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 7997
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8001
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7993
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8001
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8005
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7973
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8005
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8009
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 8013
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8013
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8017
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 8021
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8021
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8025
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8017
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8025
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8029
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8009
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8029
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 8033
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7953
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8033
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 8037
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7861
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8037
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8041
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 8045
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8045
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8049
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 8053
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8053
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8057
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8049
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8057
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 8061
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 8065
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8065
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8069
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8061
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8069
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8073
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 8077
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8077
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8081
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 8085
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8085
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8089
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8081
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8089
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8093
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8073
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8093
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 8097
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 8101
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8101
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8105
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 8109
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8109
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8113
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8105
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8113
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 8117
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 8121
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8121
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8125
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8117
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8125
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8129
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8097
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8129
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8133
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 8137
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8137
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8141
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 8145
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8145
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8149
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8141
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8149
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8153
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 8157
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8157
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8161
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 8165
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8165
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8169
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8161
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8169
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 8173
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 8177
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8177
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8181
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8173
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8181
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8185
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8153
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8185
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8189
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 8193
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8193
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8197
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 8201
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8201
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8205
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8197
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8205
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8209
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8189
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8209
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 8213
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8133
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8213
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 8217
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 8221
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8221
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8225
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 8229
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8229
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8233
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8225
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8233
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 8237
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 8241
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8241
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8245
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8237
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8245
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8249
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 8253
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8253
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8257
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 8261
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8261
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8265
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8257
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8265
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8269
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8249
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8269
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 8273
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 8277
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8277
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8281
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 8285
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8285
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8289
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8281
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8289
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 8293
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 8297
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8297
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8301
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8293
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8301
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8305
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8273
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8305
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8309
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 8313
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8313
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8317
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 8321
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8321
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8325
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8317
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8325
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8329
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 8333
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8333
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8337
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 8341
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8341
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8345
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8337
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8345
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 8349
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 8353
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8353
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8357
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8349
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8357
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8361
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8329
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8361
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8365
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 8369
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8369
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8373
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 8377
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8377
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8381
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8373
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8381
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8385
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8365
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8385
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 8389
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8309
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8389
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 8393
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8217
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8393
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8397
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8041
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8397
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8401
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 8405
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8405
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8409
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 8413
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8413
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8417
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8409
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8417
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 8421
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 8425
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8425
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8429
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8421
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8429
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8433
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 8437
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8437
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8441
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 8445
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8445
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8449
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8441
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8449
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8453
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8433
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8453
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 8457
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 8461
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8461
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8465
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 8469
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8469
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8473
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8465
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8473
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 8477
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 8481
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8481
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8485
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8477
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8485
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8489
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 8493
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8493
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8497
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 8501
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8501
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8505
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8497
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8505
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8509
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8489
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8509
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 8513
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8457
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8513
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8517
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 8521
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8521
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8525
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 8529
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8529
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8533
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8525
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8533
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 8537
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 8541
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8541
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8545
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8537
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8545
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8549
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 8553
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8553
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8557
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 8561
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8561
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8565
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8557
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8565
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8569
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8549
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8569
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 8573
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 8577
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8577
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8581
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 8585
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8585
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8589
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8581
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8589
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 8593
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 8597
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8597
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8601
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8593
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8601
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8605
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8573
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8605
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8609
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8517
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8609
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8613
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 8617
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8617
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8621
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 8625
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8625
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8629
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8621
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8629
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8633
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 8637
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8637
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8641
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 8645
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8645
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8649
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8641
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8649
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 8653
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 8657
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8657
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8661
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8653
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8661
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8665
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8633
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8665
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8669
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 8673
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8673
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8677
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 8681
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8681
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8685
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8677
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8685
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8689
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8669
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8689
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 8693
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 8697
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8697
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8701
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 8705
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8705
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8709
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8701
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8709
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 8713
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 8717
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8717
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8721
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8713
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8721
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8725
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 8729
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8729
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8733
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 8737
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8737
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8741
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8733
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8741
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8745
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8725
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8745
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 8749
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 8753
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8753
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8757
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 8761
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8761
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8765
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8757
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8765
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 8769
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 8773
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8773
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8777
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8769
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8777
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8781
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8749
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8781
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8785
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8693
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8785
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8789
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8613
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8789
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 8793
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 8797
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8797
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8801
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 8805
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8805
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8809
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8801
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8809
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8813
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 8817
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8817
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8821
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 8825
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8825
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8829
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8821
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8829
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 8833
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 8837
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8837
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8841
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8833
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8841
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8845
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8813
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8845
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8849
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 8853
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8853
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8857
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 8861
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8861
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8865
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8857
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8865
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8869
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8849
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8869
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 8873
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 8877
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8877
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8881
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 8885
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8885
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8889
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8881
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8889
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 8893
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 8897
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8897
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8901
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8893
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8901
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8905
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 8909
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8909
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8913
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 8917
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8917
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8921
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8913
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8921
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8925
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8905
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8925
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 8929
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 8933
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8933
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8937
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 8941
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8941
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8945
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8937
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8945
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 8949
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 8953
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8953
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8957
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8949
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8957
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8961
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8929
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8961
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8965
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8873
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8965
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8969
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 8973
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8973
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8977
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 8981
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8981
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8985
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8977
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 8985
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 8989
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 8993
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 8993
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 8997
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 9001
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 9001
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 9005
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8997
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 9005
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 9009
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 9013
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 9013
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 9017
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 9009
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 9017
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 9021
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8989
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 9021
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 9025
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 9029
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 9029
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 9033
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 9037
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 9037
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 9041
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 9033
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 9041
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 9045
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 9025
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 9045
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 9049
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 9053
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 9053
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 9057
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 9061
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 9061
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 9065
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 9057
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 9065
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 9069
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 9073
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 9073
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 9077
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 9069
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 9077
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 9081
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 9085
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 9085
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 9089
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 9093
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 9093
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 9097
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 9089
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 9097
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 9101
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 9081
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 9101
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 9105
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 9109
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 9109
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 9113
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @A
	li	t0, 9117
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 9117
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 9121
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 9113
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 9121
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 9125
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 9129
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 9129
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 9133
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 9125
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 9133
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 9137
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 9105
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 9137
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 9141
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 9049
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 9141
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 9145
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8969
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 9145
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 9149
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8793
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 9149
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 9153
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 8401
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 9153
	add	t0, sp, t0
	lw	t2, 0(t0)
	add	t0, t1, t2
	li	t0, 9157
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 7661
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 9157
	add	t0, sp, t0
	lw	t2, 0(t0)
	sub	t0, t1, t2
	li	t0, 9161
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 9165
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 9165
	add	t0, sp, t0
	lw	t1, 0(t0)
	li	t0, 9161
	add	t0, sp, t0
	lw	t0, 0(t0)
	sw	t0, 0(t1)
	j	.Lwhile.cond_0

.Lwhile.end_0:
	la	t2, @A
	li	t0, 9169
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 9169
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 9173
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 9173
	add	t0, sp, t0
	lw	t1, 0(t0)
	mv	a0, t1
	call	toString
	mv	t0, a0
	li	t0, 9177
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 9177
	add	t0, sp, t0
	lw	t1, 0(t0)
	mv	a0, t1
	la	t2, .str.0
	li	t0, 9181
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 9181
	add	t0, sp, t0
	lw	t1, 0(t0)
	mv	a1, t1
	call	__str_add
	mv	t0, a0
	li	t0, 9185
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @B
	li	t0, 9189
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 9189
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 9193
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 9193
	add	t0, sp, t0
	lw	t1, 0(t0)
	mv	a0, t1
	call	toString
	mv	t0, a0
	li	t0, 9197
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 9185
	add	t0, sp, t0
	lw	t1, 0(t0)
	mv	a0, t1
	li	t0, 9197
	add	t0, sp, t0
	lw	t1, 0(t0)
	mv	a1, t1
	call	__str_add
	mv	t0, a0
	li	t0, 9201
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 9201
	add	t0, sp, t0
	lw	t1, 0(t0)
	mv	a0, t1
	la	t2, .str.0
	li	t0, 9205
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 9205
	add	t0, sp, t0
	lw	t1, 0(t0)
	mv	a1, t1
	call	__str_add
	mv	t0, a0
	li	t0, 9209
	add	t0, sp, t0
	sw	t0, 0(t0)
	la	t2, @C
	li	t0, 9213
	add	t0, sp, t0
	sw	t2, 0(t0)
	li	t0, 9213
	add	t0, sp, t0
	lw	t1, 0(t0)
	lw	t0, 0(t1)
	li	t0, 9217
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 9217
	add	t0, sp, t0
	lw	t1, 0(t0)
	mv	a0, t1
	call	toString
	mv	t0, a0
	li	t0, 9221
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 9209
	add	t0, sp, t0
	lw	t1, 0(t0)
	mv	a0, t1
	li	t0, 9221
	add	t0, sp, t0
	lw	t1, 0(t0)
	mv	a1, t1
	call	__str_add
	mv	t0, a0
	li	t0, 9225
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 9225
	add	t0, sp, t0
	lw	t1, 0(t0)
	mv	a0, t1
	call	println
	mv	t0, a0
	li	t0, 9229
	add	t0, sp, t0
	sb	t0, 0(t0)
	li	t0, 0
	lw	t1, 24(sp)
	sw	t0, 0(t1)
	j	.Lexit_main_0

.Lexit_main_0:
	lw	t1, 24(sp)
	lw	t0, 0(t1)
	li	t0, 9229
	add	t0, sp, t0
	sw	t0, 0(t0)
	li	t0, 9229
	add	t0, sp, t0
	lw	t1, 0(t0)
	mv	a0, t1
	lw	ra, 0(sp)
	li	t2, 9252
	add	sp, sp, t2
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



