package com.snoopconsulting.antecedentes.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.snoopconsulting.antecedentes.domain.PermisosUsuario;

public class SecurityUtils {

	public static Collection<PermisosUsuario> getCurrentUserAuthorities() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();

		return Collections2.transform(userDetails.getAuthorities(), FUNCTION);
	}

	public static String getCurrentUserName() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

	private static Function<GrantedAuthority, PermisosUsuario> FUNCTION = new Function<GrantedAuthority, PermisosUsuario>() {

		@Override
		public PermisosUsuario apply(GrantedAuthority arg0) {
			return PermisosUsuario.valueOf(arg0.getAuthority());
		}
	};
}
