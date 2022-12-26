/* *****************************************
 * File: UserPrincipal.java
 *  12/24/2022 B>S>H>
 */
package com.harmonengineering.beans;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class UserPrincipal extends User implements UserDetails
{
    private ArrayList<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<SimpleGrantedAuthority>() ;
    public void UserPrincipal() { grantedAuthorities = new ArrayList<SimpleGrantedAuthority>() ;}
    public void buildFromUser( User user )
    {
    //    grantedAuthorities = new ArrayList<SimpleGrantedAuthority>() ;
        this.GrantAuthorities( user.getUserAuthorities()) ;
        this.setUserName( user.getUserName()) ;
        this.setUserPassword( user.getUserPassword()) ;
    }
    public void GrantAuthorities( ArrayList<String> authorityList )
    {
        System.out.println(authorityList ) ;
        for (String str : authorityList) {
            System.out.println( str ) ;
            grantedAuthorities.add(new SimpleGrantedAuthority(str));
        }
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.getUserPassword() ;
    }

    @Override
    public String getUsername() {
        return this.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
