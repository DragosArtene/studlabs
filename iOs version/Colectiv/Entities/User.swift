//
//  User.swift
//  Colectiv
//
//  Created by Lobont Andrei on 18/01/2020.
//  Copyright © 2020 Andrei Lobont. All rights reserved.
//

import Foundation

struct User: Codable {
    var firstName: String
    var lastName: String
    var email: String
    var completezQuizes: [Quiz]
}
