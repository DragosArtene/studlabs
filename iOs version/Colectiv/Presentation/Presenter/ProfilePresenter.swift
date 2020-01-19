//
//  ProfilePresenter.swift
//  Colectiv
//
//  Created by Lobont Andrei on 18/01/2020.
//  Copyright © 2020 Andrei Lobont. All rights reserved.
//

import Foundation

class ProfilePresenter {
    private weak var view: ProfileView?
    private weak var navigation: ProfileNavigation?
    private(set) var user: User? {
        get {
            guard let persistentValue = UserDefaults.standard.value(forKey: "user") as? Data,
                let user = try? JSONDecoder().decode(User.self, from: persistentValue) else {
                    return nil
            }
            return user
        }
        
        set {
            let data = try? JSONEncoder().encode(newValue)
            UserDefaults.standard.set(data, forKey: "user")
        }
    }
    
    init(view: ProfileView, navigation: ProfileNavigation) {
        self.view = view
        self.navigation = navigation
    }
    
    func viewDidLoad() {
        
    }
    
    func viewDidAppear() {
        view?.reloadData()
    }
    
    func numberOfDoneQuizes() -> Int {
        if user?.completezQuizes.count ?? 0 <= 6 {
            return user?.completezQuizes.count ?? 0
        }
        
        return 6
    }
    
    func getQuizName(at index: Int) -> String {
        return user?.completezQuizes[index].title ?? ""
    }
    
    func getQuizImage(at index: Int) -> String {
        return user?.completezQuizes[index].imageName ?? ""
    }
    
    func logoutPressed() {
        navigation?.navigateToLogin()
    }
}
