//
//  MainPresenter.swift
//  Colectiv
//
//  Created by Andrei Lobont on 13/01/2020.
//  Copyright © 2020 Andrei Lobont. All rights reserved.
//

import Foundation

class MainPresenter {
    private weak var navigation: MainNavigation?
    
    init(navigation: MainNavigation) {
        self.navigation = navigation
    }
    
    func viewDidLoad() {
        isAuthenticated()
    }
    
    private func isAuthenticated() {
        navigation?.navigateToLogin()
    }
}
