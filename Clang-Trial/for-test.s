	.text
	.file	"for-test.cpp"
	.section	.text.startup,"ax",@progbits
	.p2align	2               # -- Begin function __cxx_global_var_init
	.type	__cxx_global_var_init,@function
__cxx_global_var_init:                  # @__cxx_global_var_init
	.cfi_startproc
# %bb.0:
	c.addi	sp, -16
	.cfi_def_cfa_offset 16
	c.swsp	ra, 12(sp)
	c.swsp	s0, 8(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	c.addi4spn	s0, sp, 16
	.cfi_def_cfa s0, 0
	lui	a0, %hi(_ZStL8__ioinit)
	addi	a0, a0, %lo(_ZStL8__ioinit)
	sw	a0, -12(s0)
	call	_ZNSt8ios_base4InitC1Ev
	lui	a0, %hi(_ZNSt8ios_base4InitD1Ev)
	addi	a0, a0, %lo(_ZNSt8ios_base4InitD1Ev)
	lui	a1, %hi(__dso_handle)
	addi	a2, a1, %lo(__dso_handle)
	lw	a1, -12(s0)
	call	__cxa_atexit
	c.lwsp	s0, 8(sp)
	c.lwsp	ra, 12(sp)
	c.addi	sp, 16
	c.jr	ra
.Lfunc_end0:
	.size	__cxx_global_var_init, .Lfunc_end0-__cxx_global_var_init
	.cfi_endproc
                                        # -- End function
	.text
	.globl	main                    # -- Begin function main
	.p2align	2
	.type	main,@function
main:                                   # @main
# %bb.0:
	c.addi	sp, -32
	c.swsp	ra, 28(sp)
	c.swsp	s0, 24(sp)
	c.addi4spn	s0, sp, 32
	c.li	a0, 0
	sw	a0, -12(s0)
	sw	a0, -16(s0)
	sw	a0, -20(s0)
	c.j	.LBB1_1
.LBB1_1:                                # =>This Inner Loop Header: Depth=1
	lw	a0, -20(s0)
	c.li	a1, 9
	blt	a1, a0, .LBB1_4
	c.j	.LBB1_2
.LBB1_2:                                #   in Loop: Header=BB1_1 Depth=1
	lw	a0, -20(s0)
	lw	a1, -16(s0)
	c.add	a0, a1
	sw	a0, -16(s0)
	c.j	.LBB1_3
.LBB1_3:                                #   in Loop: Header=BB1_1 Depth=1
	lw	a0, -20(s0)
	c.addi	a0, 1
	sw	a0, -20(s0)
	c.j	.LBB1_1
.LBB1_4:
	lw	a0, -16(s0)
	c.lwsp	s0, 24(sp)
	c.lwsp	ra, 28(sp)
	c.addi16sp	sp, 32
	c.jr	ra
.Lfunc_end1:
	.size	main, .Lfunc_end1-main
                                        # -- End function
	.section	.text.startup,"ax",@progbits
	.p2align	2               # -- Begin function _GLOBAL__sub_I_for_test.cpp
	.type	_GLOBAL__sub_I_for_test.cpp,@function
_GLOBAL__sub_I_for_test.cpp:            # @_GLOBAL__sub_I_for_test.cpp
	.cfi_startproc
# %bb.0:
	c.addi	sp, -16
	.cfi_def_cfa_offset 16
	c.swsp	ra, 12(sp)
	c.swsp	s0, 8(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	c.addi4spn	s0, sp, 16
	.cfi_def_cfa s0, 0
	call	__cxx_global_var_init
	c.lwsp	s0, 8(sp)
	c.lwsp	ra, 12(sp)
	c.addi	sp, 16
	c.jr	ra
.Lfunc_end2:
	.size	_GLOBAL__sub_I_for_test.cpp, .Lfunc_end2-_GLOBAL__sub_I_for_test.cpp
	.cfi_endproc
                                        # -- End function
	.type	_ZStL8__ioinit,@object  # @_ZStL8__ioinit
	.section	.sbss,"aw",@nobits
_ZStL8__ioinit:
	.zero	1
	.size	_ZStL8__ioinit, 1

	.hidden	__dso_handle
	.section	.init_array,"aw",@init_array
	.p2align	2
	.word	_GLOBAL__sub_I_for_test.cpp
	.ident	"clang version 10.0.0-4ubuntu1 "
	.section	".note.GNU-stack","",@progbits
	.addrsig
	.addrsig_sym __cxx_global_var_init
	.addrsig_sym __cxa_atexit
	.addrsig_sym _GLOBAL__sub_I_for_test.cpp
	.addrsig_sym _ZStL8__ioinit
	.addrsig_sym __dso_handle
